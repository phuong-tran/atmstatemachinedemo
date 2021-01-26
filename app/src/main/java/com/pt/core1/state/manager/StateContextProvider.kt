package com.pt.core1.state.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.context.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import java.util.concurrent.atomic.AtomicReference

class StateContextProvider private constructor(
    private val defaultStateProvider: IDefaultStateProvider,
    private val graphBuilderProvider: IGraphBuilderProvider,
    private val transactionActionProvider: ITransactionActionProvider
) : IStateContextProvider {
    private val stateMachineHolder = AtomicReference<StateMachine<State, Event, SideEffect>>()

    private fun getStateMachine(): StateMachine<State, Event, SideEffect> = stateMachineHolder.get()

    private val stateHolder: AtomicReference<State> =
        AtomicReference(defaultStateProvider.defaultState())

    private val dataTransitionDataHolder = AtomicReference<TransitionData>()

    override fun getCurrentState(): State = stateHolder.get()

    override fun getCurrentTransitionData(): TransitionData = dataTransitionDataHolder.get()

    override fun setCurrentState(state: State) {
        stateHolder.set(state)
    }

    override fun setTransitionData(transitionData: TransitionData) {
        dataTransitionDataHolder.set(transitionData)
    }

    override fun transactionActionProvider() = transactionActionProvider


    override fun createStateMachine(
        initState: State,
    ): StateMachine<State, Event, SideEffect> {
        return StateMachine.createWithDelegate(
            graphBuilderProvider.provideGraphBuilder().apply {
                initialState(initState)
            }
        ) { fromState, event, toState, sideEffect ->
            val transitionData = TransitionData(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
            setCurrentState(toState)
            setTransitionData(transitionData)
            transactionActionProvider.onTransaction(transitionData)
        }
    }

    override fun createStateMachineThenSetToHolder(initState: State) {
        stateMachineHolder.set(createStateMachine(initState))
    }

    override fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> {
        return createStateMachine(defaultStateProvider.defaultState())
    }

    override fun createStateMachineDefaultStateThenSetToHolder() {
        stateMachineHolder.set(createStateMachineDefaultState())
    }

    override fun setNewState(state: State) {
        getStateMachine().with {
            initialState(state)
        }.also {
            setCurrentState(state)
            stateMachineHolder.set(it)
        }
    }

    override fun transition(event: Event) {
        getStateMachine().transition(event)
    }

    override fun defaultState(): State = defaultStateProvider.defaultState()

    // Call this at last moment, don't ever move this to the top
    init {
        createStateMachineDefaultStateThenSetToHolder()
    }

    companion object {
        fun createStateContextProvider(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): StateContextProvider {
            return StateContextProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}
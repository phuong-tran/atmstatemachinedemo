package com.pt.core1.state.controller.provider.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.controller.provider.DefaultStateProvider
import java.util.concurrent.atomic.AtomicReference

class StateContextProviderImpl(
    private val defaultStateProvider: DefaultStateProvider,
    private val graphBuilderProvider: GraphBuilderProvider,
    private val transactionActionProvider: TransactionActionProvider
) : StateContextProvider {

    init {
        createStateMachineDefaultStateThenSetToHolder()
    }

    private val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>> =
        AtomicReference()

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

    override fun graphBuilderProvider(): GraphBuilderProvider = graphBuilderProvider

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


    override fun newState(state: State) {
        getStateMachine().with {
            initialState(state)
        }.also {
            stateMachineHolder.set(it)
        }
    }

    override fun transition(event: Event) {
        getStateMachine().transition(event)
    }

    override fun defaultState(): State = defaultStateProvider.defaultState()
}
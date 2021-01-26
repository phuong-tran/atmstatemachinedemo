package com.pt.core1.state.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IImmutableStateContextProvider
import java.util.concurrent.atomic.AtomicReference

abstract class ImmutableStateContextBaseProvider(
    protected val defaultStateProvider: IDefaultStateProvider,
    protected val graphBuilderProvider: IGraphBuilderProvider,
    protected val transactionActionProvider: ITransactionActionProvider
) : IImmutableStateContextProvider {
    protected abstract val isWritable: Boolean

    override fun transactionActionProvider(): ITransactionActionProvider = transactionActionProvider

    private val stateMachineHolder = AtomicReference<StateMachine<State, Event, SideEffect>>()

    private val stateHolder: AtomicReference<State> = AtomicReference(defaultState())
    private val dataTransitionDataHolder = AtomicReference<TransitionData>()

    private fun getStateMachine(): StateMachine<State, Event, SideEffect> = stateMachineHolder.get()

    override fun getCurrentState(): State = stateHolder.get()

    override fun getCurrentTransitionData(): TransitionData = dataTransitionDataHolder.get()

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
            stateMachineHolder.set(it)
        }
    }

    override fun transition(event: Event) {
        getStateMachine().transition(event)
    }

    final override fun defaultState(): State = defaultStateProvider.defaultState()

    final override fun setCurrentState(state: State) {
        if (isWritable) {
            stateHolder.set(state)
        } else {
            throw IllegalAccessError("Not Supported")
        }
    }

    final override fun setTransitionData(transitionData: TransitionData) {
        if (isWritable) {
            dataTransitionDataHolder.set(transitionData)
        } else {
            throw IllegalAccessError("Not Supported")
        }
    }
}
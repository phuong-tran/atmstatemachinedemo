package com.pt.core1.state.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.*
import java.util.concurrent.atomic.AtomicReference

class StateMachineProviderTemplate private constructor(
    private val graphBuilderProvider: GraphBuilderProvider,
    private val transactionActionProvider: TransactionActionProvider,
    private val defaultStateProvider: DefaultStateProvider,
) : StateMachineProvider {

    private val stateMachineHolder = AtomicReference<StateMachine<State, Event, SideEffect>>()

    private val stateHolder: AtomicReference<State> =
        AtomicReference(defaultStateProvider.provideDefaultState())

    private val dataTransitionDataHolder = AtomicReference<TransitionData>()

    override fun getStateMachine(): StateMachine<State, Event, SideEffect> =
        stateMachineHolder.get()

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

    /*override fun createStateMachine(
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
    }*/

    /* private fun createStateMachineThenSetToHolder(initState: State) {
         stateMachineHolder.set(createStateMachine(initState))
     }*/

    /* override fun defaultState(): State = defaultStateProvider.defaultState()*/

    private fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> {
        return createStateMachine(defaultStateProvider.provideDefaultState())
    }

    private fun createStateMachineDefaultStateThenSetToHolder() {
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

    override fun getCurrentState(): State = stateHolder.get()

    override fun getCurrentTransitionData(): TransitionData = dataTransitionDataHolder.get()

    override fun setCurrentState(state: State) {
        stateHolder.set(state)
    }

    override fun setTransitionData(transitionData: TransitionData) {
        dataTransitionDataHolder.set(transitionData)
    }

    init {
        createStateMachineDefaultStateThenSetToHolder()
    }

    companion object {
        fun create(
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider,
            defaultStateProvider: DefaultStateProvider
        ): StateMachineProvider {
            return StateMachineProviderTemplate(
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider,
                defaultStateProvider = defaultStateProvider
            )
        }
    }
}
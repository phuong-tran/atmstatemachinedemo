package com.pt.core.state.manager

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.provider.*
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableStateMachineProvider
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider
import com.pt.core.state.provider.transition.ChangeStateProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider
import java.util.concurrent.atomic.AtomicReference

class StateMachineProviderTemplate private constructor(
    private val graphBuilderProvider: GraphBuilderProvider,
    private val transactionActionProvider: StateTransactionDataProvider,
    private val defaultStateProvider: DefaultStateProvider,
) : StateContextChangeableStateMachineProvider, DefaultStateProvider by defaultStateProvider {

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

    private fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> {
        return createStateMachine(defaultStateProvider.provideDefaultState())
    }

    private fun createStateMachineDefaultStateThenSetToHolder() {
        stateMachineHolder.set(createStateMachineDefaultState())
    }

    override fun setNewState(state: State) {
        getStateMachine().with {
            initialState(state).also {
                stateHolder.set(state)
            }
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
        private inline fun <reified T> create(
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider,
            defaultStateProvider: DefaultStateProvider
        ): T {
            return StateMachineProviderTemplate(
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider,
                defaultStateProvider = defaultStateProvider
            ) as T
        }

        fun createForReadOnly(
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider,
            defaultStateProvider: DefaultStateProvider
        ): StateContextReadOnlyStateMachineProvider {
            return create(
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider,
                defaultStateProvider = defaultStateProvider
            )
        }

        fun createForChangeable(
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider,
            defaultStateProvider: DefaultStateProvider
        ): StateContextChangeableProvider {
            return create(
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider,
                defaultStateProvider = defaultStateProvider
            )
        }
    }
}
package com.pt.core1.state.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextProvider

class MutableStateContextProvider private constructor(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider,
) : ImmutableStateContextBaseProvider(
    defaultStateProvider = defaultStateProvider,
    graphBuilderProvider = graphBuilderProvider,
    transactionActionProvider = transactionActionProvider
), IMutableStateContextProvider {
    override val isWritable = true

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

    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): IMutableStateContextProvider {
            return MutableStateContextProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


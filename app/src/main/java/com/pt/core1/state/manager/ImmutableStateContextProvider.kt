package com.pt.core1.state.manager

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateMachineProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IStateContextProvider
import java.lang.IllegalStateException

class ImmutableStateContextProvider(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider
) : IStateContextProvider,
    IStateMachineProvider by StateMachineProvider.create(
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider,
        defaultStateProvider = defaultStateProvider
    ) {

    override fun setCurrentState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun setTransitionData(transitionData: TransitionData) {
        throw IllegalStateException("Not Supported")
    }

    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): IStateContextProvider {
            return ImmutableStateContextProvider.create(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}
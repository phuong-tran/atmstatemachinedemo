package com.pt.core1.state.manager

import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IImmutableStateContextProvider

class ImmutableStateContextProvider(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider
) : ImmutableStateContextBaseProvider(
    defaultStateProvider = defaultStateProvider,
    graphBuilderProvider = graphBuilderProvider,
    transactionActionProvider = transactionActionProvider
) {
    override val isWritable = false

    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): IImmutableStateContextProvider {
            return ImmutableStateContextProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}
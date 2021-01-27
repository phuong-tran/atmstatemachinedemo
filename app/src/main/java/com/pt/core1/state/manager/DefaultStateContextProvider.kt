package com.pt.core1.state.manager

import com.pt.core1.state.provider.*
import com.pt.core1.state.provider.context.template.IDefaultStateContextProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextProvider

class DefaultStateContextProvider private constructor(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider,
) : IDefaultStateContextProvider,
    IMutableStateContextProvider by MutableStateContextProvider.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ),

    ISaveStateToBundleProvider by SaveStateToBundleProvider,
    ISaveStateToSavedHandlerProvider by SaveStateToSavedHandlerProvider {

    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): IDefaultStateContextProvider {
            return DefaultStateContextProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




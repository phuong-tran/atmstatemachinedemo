package com.pt.core1.state.manager

import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ISaveStateToSavedHandlerProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextSupportSavedHandlerStorageProvider


class MutableStateContextSupportSavedHandlerStorageProvider(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider,
) : IMutableStateContextSupportSavedHandlerStorageProvider,
    IMutableStateContextProvider by MutableStateContextProvider.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ),
    ISaveStateToSavedHandlerProvider by SaveStateToSavedHandlerProvider {
    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ): IMutableStateContextSupportSavedHandlerStorageProvider {
            return MutableStateContextSupportSavedHandlerStorageProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


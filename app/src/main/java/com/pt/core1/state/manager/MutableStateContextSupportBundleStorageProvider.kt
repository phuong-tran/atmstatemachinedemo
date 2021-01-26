package com.pt.core1.state.manager

import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ISaveStateToBundleProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextProvider
import com.pt.core1.state.provider.context.template.IMutableStateContextSupportBundleStorageProvider

class MutableStateContextSupportBundleStorageProvider private constructor(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider,
) : IMutableStateContextSupportBundleStorageProvider,
    IMutableStateContextProvider by MutableStateContextProvider.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ),
    ISaveStateToBundleProvider by SaveStateToBundleProvider {
    companion object {
        fun create(
            defaultStateProvider: IDefaultStateProvider,
            graphBuilderProvider: IGraphBuilderProvider,
            transactionActionProvider: ITransactionActionProvider
        ) {
            MutableStateContextSupportBundleStorageProvider(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}



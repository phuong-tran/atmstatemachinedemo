package com.pt.core1.state.manager

import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.provider.template.StateContextReadWriteProvider
import com.pt.core1.state.provider.template.StateContextBundleStorageProvider

class StateContextBundleStorageProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : StateContextBundleStorageProvider,
    StateContextReadWriteProvider by StateContextReadWriteProviderTemplate.create(
        defaultStateProvider = defaultStateProvider,
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider
    ) {
    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider
        ): StateContextBundleStorageProvider {
            return StateContextBundleStorageProviderTemplate.create(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




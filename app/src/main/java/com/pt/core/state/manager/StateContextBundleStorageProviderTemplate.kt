package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

class StateContextBundleStorageProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: StateTransactionDataProvider,
) : StateContextBundleStorageProvider,
    StateContextChangeableProvider by StateContexChangeableProviderTemplate.create(
        defaultStateProvider = defaultStateProvider,
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider
    ) {
    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider
        ): StateContextBundleStorageProvider {
            return StateContextBundleStorageProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




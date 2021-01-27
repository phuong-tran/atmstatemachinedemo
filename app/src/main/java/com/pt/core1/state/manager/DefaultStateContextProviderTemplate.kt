package com.pt.core1.state.manager

import com.pt.core1.state.provider.*
import com.pt.core1.state.provider.context.template.DefaultStateContextProvider
import com.pt.core1.state.provider.context.template.StateContextReadWriteProvider

class DefaultStateContextProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : DefaultStateContextProvider,
    StateContextReadWriteProvider by StateContextReadWriteProviderTemplate.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ),

    SaveStateToBundleProvider by SaveStateToBundleProviderTemplate,
    SaveStateToSavedHandlerProvider by SaveStateToSavedHandlerProviderTemplate {

    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider
        ): DefaultStateContextProvider {
            return DefaultStateContextProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




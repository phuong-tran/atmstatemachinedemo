package com.pt.core1.state.manager

import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.provider.template.StateContextReadWriteProvider
import com.pt.core1.state.provider.template.StateContextSavedHandler


class StateContextSavedHandlerStorageTemplate(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : StateContextSavedHandler,
    StateContextReadWriteProvider by StateContextReadWriteProviderTemplate.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ) {
    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider
        ): StateContextSavedHandler {
            return StateContextSavedHandlerStorageTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


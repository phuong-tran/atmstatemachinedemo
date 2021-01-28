package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.TransactionActionProvider
import com.pt.core.state.provider.template.StateContextReadWriteProvider
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider


class StateContextSavedHandlerTemplate(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : StateContextSavedHandlerProvider,
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
        ): StateContextSavedHandlerProvider {
            return StateContextSavedHandlerTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


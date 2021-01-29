package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider


class StateContextSavedHandlerTemplate(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: StateTransactionDataProvider,
) : StateContextSavedHandlerProvider,
    StateContextChangeableProvider by StateContexChangeableProviderTemplate.create(
        defaultStateProvider,
        graphBuilderProvider,
        transactionActionProvider
    ) {
    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider
        ): StateContextSavedHandlerProvider {
            return StateContextSavedHandlerTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


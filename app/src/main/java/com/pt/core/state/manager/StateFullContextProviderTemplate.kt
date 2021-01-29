package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider
import com.pt.core.state.provider.template.StateFullContextProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

class StateFullContextProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: StateTransactionDataProvider,
) : StateFullContextProvider,
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
        ): StateFullContextProvider {
            return StateFullContextProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




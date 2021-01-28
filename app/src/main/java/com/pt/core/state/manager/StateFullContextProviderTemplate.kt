package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.TransactionActionProvider
import com.pt.core.state.provider.template.StateFullContextProvider
import com.pt.core.state.provider.template.StateContextReadWriteProvider

class StateFullContextProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : StateFullContextProvider,
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
        ): StateFullContextProvider {
            return StateFullContextProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}




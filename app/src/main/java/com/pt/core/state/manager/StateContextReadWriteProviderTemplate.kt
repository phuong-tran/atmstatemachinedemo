package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.StateMachineProvider
import com.pt.core.state.provider.TransactionActionProvider
import com.pt.core.state.provider.template.StateContextReadWriteProvider

open class StateContextReadWriteProviderTemplate(
    defaultStateProvider: DefaultStateProvider,
    private val graphBuilderProvider: GraphBuilderProvider,
    private val transactionActionProvider: TransactionActionProvider
) : StateContextReadWriteProvider,
    StateMachineProvider by StateMachineProviderTemplate.create(
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider,
        defaultStateProvider = defaultStateProvider
    ) {

    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider
        ): StateContextReadWriteProvider {
            return StateContextReadWriteProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}

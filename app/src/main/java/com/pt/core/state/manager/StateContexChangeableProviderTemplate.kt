package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider

open class StateContexChangeableProviderTemplate(
    defaultStateProvider: DefaultStateProvider,
    private val graphBuilderProvider: GraphBuilderProvider,
    private val transactionActionProvider: StateTransactionDataProvider
) : StateContextChangeableProvider by StateMachineProviderTemplate.createForChangeable(
    graphBuilderProvider = graphBuilderProvider,
    transactionActionProvider = transactionActionProvider,
    defaultStateProvider = defaultStateProvider
) {

    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider
        ): StateContextChangeableProvider {
            return StateContexChangeableProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}


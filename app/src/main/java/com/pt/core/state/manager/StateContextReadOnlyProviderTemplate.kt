package com.pt.core.state.manager

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.StateMachineProvider
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider

class StateContextReadOnlyProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: StateTransactionDataProvider
) : StateContextReadOnlyStateMachineProvider,
    StateMachineProvider by StateMachineProviderTemplate.createForReadOnly(
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider,
        defaultStateProvider = defaultStateProvider
    ), DefaultStateProvider by defaultStateProvider {
    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: StateTransactionDataProvider
        ): StateContextReadOnlyProvider {
            return StateContextReadOnlyProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}
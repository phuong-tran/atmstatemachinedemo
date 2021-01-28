package com.pt.core.state.manager

import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.StateMachineProvider
import com.pt.core.state.provider.TransactionActionProvider
import com.pt.core.state.provider.template.StateContextReadOnlyProvider
import java.lang.IllegalStateException

class StateContextReadOnlyProviderTemplate(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider
) : StateContextReadOnlyProvider,
    StateMachineProvider by StateMachineProviderTemplate.create(
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider,
        defaultStateProvider = defaultStateProvider
    ) {

    override fun setCurrentState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun setTransitionData(transitionData: TransitionData) {
        throw IllegalStateException("Not Supported")
    }

    override fun setNewState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    companion object {
        fun create(
            defaultStateProvider: DefaultStateProvider,
            graphBuilderProvider: GraphBuilderProvider,
            transactionActionProvider: TransactionActionProvider
        ): StateContextReadOnlyProvider {
            return StateContextReadOnlyProviderTemplate(
                defaultStateProvider = defaultStateProvider,
                graphBuilderProvider = graphBuilderProvider,
                transactionActionProvider = transactionActionProvider
            )
        }
    }
}
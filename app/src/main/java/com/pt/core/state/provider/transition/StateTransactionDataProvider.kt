package com.pt.core.state.provider.transition

import com.pt.core.data.TransitionData

interface StateTransactionDataProvider {
    fun onTransaction(transitionData: TransitionData)
}
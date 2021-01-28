package com.pt.core.state.provider

import com.pt.core.data.TransitionData

interface TransactionActionProvider {
    fun onTransaction(transitionData: TransitionData)
}
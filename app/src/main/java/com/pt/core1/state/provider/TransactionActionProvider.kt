package com.pt.core1.state.provider

import com.pt.core1.data.TransitionData

interface TransactionActionProvider {
    fun onTransaction(transitionData: TransitionData)
}
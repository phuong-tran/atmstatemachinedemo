package com.pt.core1.state.controller.provider.manager

import com.pt.core1.data.TransitionData

interface TransactionActionProvider {
    fun onTransaction(transitionData: TransitionData)
}
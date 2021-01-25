package com.pt.core1.state.provider

import com.pt.core1.data.TransitionData

interface ITransactionActionProvider {
    fun onTransaction(transitionData: TransitionData)
}
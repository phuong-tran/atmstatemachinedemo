package com.pt.core1.state.controller.provider

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface SaveStateHandler {
    fun saveState(state: State)
    fun saveTransitionData(transitionData: TransitionData)
}
package com.pt.core1.state.controller.provider

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface RestoreStateProvider {
    fun restoreCurrentTransitionData(transitionData: TransitionData)
    fun restoreCurrentState(state: State)
}
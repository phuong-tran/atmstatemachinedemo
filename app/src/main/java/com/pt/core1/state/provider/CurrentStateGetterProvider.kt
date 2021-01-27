package com.pt.core1.state.provider

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface CurrentStateGetterProvider {
    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionData
}
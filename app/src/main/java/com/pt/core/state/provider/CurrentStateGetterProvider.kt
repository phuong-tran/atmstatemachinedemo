package com.pt.core.state.provider

import com.pt.core.data.State
import com.pt.core.data.TransitionData

interface CurrentStateGetterProvider {
    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionData
}
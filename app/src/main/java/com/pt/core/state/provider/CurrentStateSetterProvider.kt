package com.pt.core.state.provider

import com.pt.core.data.State
import com.pt.core.data.TransitionData

interface CurrentStateSetterProvider {
    fun setCurrentState(state: State)
    fun setTransitionData(transitionData: TransitionData)
}
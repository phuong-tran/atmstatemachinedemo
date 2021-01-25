package com.pt.core1.state.provider

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface ICurrentStateSetterProvider {
    fun setCurrentState(state: State)
    fun setTransitionData(transitionData: TransitionData)
}
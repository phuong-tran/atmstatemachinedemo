package com.pt.state.navigation.state.manual.update

import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData

interface UpdateStateHandler: UpdateGenericState<State> {
    fun setCurrentTransitionData(transitionData: TransitionData)
}
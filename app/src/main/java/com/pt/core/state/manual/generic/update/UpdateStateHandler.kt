package com.pt.core.state.manual.generic.update

import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData

interface UpdateStateHandler: UpdateGenericState<State> {
    fun setCurrentTransitionData(transitionData: TransitionData)
}
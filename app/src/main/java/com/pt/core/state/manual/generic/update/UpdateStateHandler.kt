package com.pt.core.state.manual.generic.update

import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.manual.generic.update.UpdateGenericState

interface UpdateStateHandler: UpdateGenericState<State> {
    fun setCurrentTransitionData(transitionData: TransitionData)
}
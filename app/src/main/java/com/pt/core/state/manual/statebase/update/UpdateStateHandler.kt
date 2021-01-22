package com.pt.core.state.manual.statebase.update

import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.manual.generic.update.UpdateGenericStateHandler

interface UpdateStateHandler: UpdateGenericStateHandler<State> {
    fun setCurrentTransitionData(transitionData: TransitionData)
}
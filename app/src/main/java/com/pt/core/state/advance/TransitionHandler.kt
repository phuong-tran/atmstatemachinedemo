package com.pt.core.state.advance

import com.pt.core.data.transition.TransitionData

interface TransitionHandler {
    fun onTransit(data: TransitionData)
}

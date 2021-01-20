package com.pt.state.navigation.state.advance

import com.pt.state.data.transition.TransitionData

interface TransitionHandler {
    fun onTransit(data: TransitionData)
}

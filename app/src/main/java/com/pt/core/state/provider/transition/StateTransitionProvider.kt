package com.pt.core.state.provider.transition

import com.pt.core.data.Event
import com.pt.core.data.State

interface StateTransitionProvider {
    fun transition(event: Event)
}
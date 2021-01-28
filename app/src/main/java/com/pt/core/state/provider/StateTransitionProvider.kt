package com.pt.core.state.provider

import com.pt.core.data.Event
import com.pt.core.data.State

interface StateTransitionProvider {
    fun setNewState(state: State)
    fun transition(event: Event)
}
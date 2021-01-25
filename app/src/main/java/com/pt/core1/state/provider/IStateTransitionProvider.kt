package com.pt.core1.state.provider

import com.pt.core1.data.Event
import com.pt.core1.data.State

interface IStateTransitionProvider {
    fun setNewState(state: State)
    fun transition(event: Event)
}
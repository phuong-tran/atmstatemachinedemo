package com.pt.core1.state.controller.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.controller.provider.manager.StateMachine

interface StateTransition {
    fun getStateMachine(): StateMachine<State, Event, SideEffect>

    fun transition(event: Event) {
        getStateMachine().transition(event)
    }

    fun onTransaction(transitionData: TransitionData)
}
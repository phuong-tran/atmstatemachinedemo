package com.pt.core1.state.helper

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine

fun buildGraph(
    withState: State? = null,
    builder: StateMachine.GraphBuilder<State, Event, SideEffect>.() -> Unit
): StateMachine.GraphBuilder<State, Event, SideEffect> {
    return StateMachine.GraphBuilder<State, Event, SideEffect>().apply {
        withState?.let {
            initialState(it)
        }
        builder()
    }
}
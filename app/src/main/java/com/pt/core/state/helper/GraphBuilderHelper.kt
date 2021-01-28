package com.pt.core.state.helper

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine

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
package com.pt.core


import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.manager.StateMachine

fun StateMachine.Transition.Valid<State, Event, SideEffect>.toTransitionData(): TransitionData =
    TransitionData(fromState = fromState, event = event, toState = toState, sideEffect = sideEffect)

inline fun <reified T : Any> create(f: () -> T): T {
    return f()
}
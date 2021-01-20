package com.pt.state


import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.manager.StateMachine

/*fun <STATE: Parcelable, EVENT: Parcelable, SIDE_EFFECT: Parcelable>StateMachine.Transition.Valid<STATE, EVENT, SIDE_EFFECT>.toTransitionData(): TransitionDataBase<State, Event, State, SideEffect> {
    return TransitionData(fromState = fromState as State, event = event as Event, toState = toState as State, sideEffect = sideEffect as SideEffect)
}*/


fun StateMachine.Transition.Valid<State, Event, SideEffect>.toTransitionData(): TransitionData =
    TransitionData(fromState = fromState, event = event, toState = toState, sideEffect = sideEffect)

inline fun <reified T : Any> create(f: () -> T): T {
    return f()
}
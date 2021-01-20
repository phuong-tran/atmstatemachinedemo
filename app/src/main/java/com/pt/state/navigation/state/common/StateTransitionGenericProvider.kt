package com.pt.state.navigation.state.common

import android.os.Parcelable
import com.pt.state.manager.StateMachine

interface StateTransitionGenericProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateMachineGenericProvider<State, Event, SideEffect> {
    fun givenState(
        state: State
    ): StateMachine<State, Event, SideEffect> {
        return stateMachine.with { initialState(state) }
    }

    fun transition(event: Event) {
        stateMachine.transition(event)
    }

    fun onTransaction(fromState: State, event: Event, toState: State, sideEffect: SideEffect?)
}

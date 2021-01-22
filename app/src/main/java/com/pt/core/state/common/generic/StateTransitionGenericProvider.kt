package com.pt.core.state.common.generic

import android.os.Parcelable
import com.pt.core.state.manager.StateMachine

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

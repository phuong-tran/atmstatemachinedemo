package com.pt.core.state.common.generic

import android.os.Parcelable
import com.pt.core.state.manager.StateMachine

interface StateTransitionGenericProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateMachineGenericProvider<State, Event, SideEffect> {
    fun givenState(
        state: State
    ): StateMachine<State, Event, SideEffect> {
        return provideStateMachine().with { initialState(state) }
    }

    fun transition(event: Event) {
        provideStateMachine().transition(event)
    }

    fun onTransaction(fromState: State, event: Event, toState: State, sideEffect: SideEffect?)
}

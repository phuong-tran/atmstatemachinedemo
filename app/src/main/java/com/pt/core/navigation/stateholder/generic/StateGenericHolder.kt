package com.pt.core.navigation.stateholder.generic

import android.os.Parcelable
import com.pt.core.state.manager.StateMachine
import java.util.concurrent.atomic.AtomicReference

interface StateGenericHolder<State: Parcelable, Event: Parcelable, SideEffect: Parcelable> {
    fun initializeStateMachine(): StateMachine<State, Event, SideEffect>

    val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>>

    fun setStateWith(state: State) {
        stateMachineHolder.get().with {
            initialState(state)
        }.also {
            stateMachineHolder.set(it)
        }
    }

    fun getStateMachine(): StateMachine<State, Event, SideEffect> =
        stateMachineHolder.get()
}
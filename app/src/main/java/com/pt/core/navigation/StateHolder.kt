package com.pt.core.navigation

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine
import java.util.concurrent.atomic.AtomicReference

interface StateHolder {
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
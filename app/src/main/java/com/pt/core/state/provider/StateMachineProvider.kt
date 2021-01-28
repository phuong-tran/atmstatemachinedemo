package com.pt.core.state.provider

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine
import com.pt.core.state.provider.template.StateHolderProvider

interface StateMachineProvider : StateTransitionProvider, StateHolderProvider {
    fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect>
    fun getStateMachine(): StateMachine<State, Event, SideEffect>
}
package com.pt.core1.state.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine
import com.pt.core1.state.provider.template.StateHolderProvider

interface StateMachineProvider : StateTransitionProvider, StateHolderProvider {
    fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect>
    fun getStateMachine(): StateMachine<State, Event, SideEffect>
}
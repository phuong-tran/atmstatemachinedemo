package com.pt.core.state.provider

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine
import com.pt.core.state.provider.template.StateHolderProvider
import com.pt.core.state.provider.transition.StateTransitionProvider

interface StateMachineProvider : StateTransitionProvider, CurrentStateGetterProvider {
    fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect>
    fun getStateMachine(): StateMachine<State, Event, SideEffect>
}
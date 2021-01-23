package com.pt.core1.state.controller.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.controller.provider.manager.StateMachine

interface StateMachineCreator: DefaultStateProvider {
    fun createStateMachine(initState: State) : StateMachine<State, Event, SideEffect>
    fun createStateMachineThenSetToHolder(initState: State)
    fun createStateMachineDefaultState() : StateMachine<State, Event, SideEffect>
    fun createStateMachineDefaultStateThenSetToHolder()
}
package com.pt.core1.state.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine

interface IStateMachineCreatorProvider: IDefaultStateProvider {
    fun createStateMachine(initState: State) : StateMachine<State, Event, SideEffect>
    fun createStateMachineThenSetToHolder(initState: State)
    fun createStateMachineDefaultState() : StateMachine<State, Event, SideEffect>
    fun createStateMachineDefaultStateThenSetToHolder()
}
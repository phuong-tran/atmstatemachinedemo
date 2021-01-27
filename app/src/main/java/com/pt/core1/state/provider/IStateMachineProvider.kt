package com.pt.core1.state.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine
import com.pt.core1.state.provider.context.template.IStateHolderProvider

interface IStateMachineProvider : IStateTransitionProvider, IStateHolderProvider {
    fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect>

    /* fun createStateMachineThenSetToHolder(initState: State)
     fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect>*/
    //fun createStateMachineDefaultStateThenSetToHolder()
    fun getStateMachine(): StateMachine<State, Event, SideEffect>
}
package com.pt.core1.controller.activity.simple

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.manager.StateMachine
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider

abstract class SimpleStateActivity2 : SimpleStateActivity(), IGraphBuilderProvider,
    ITransactionActionProvider, IDefaultStateProvider, IStateContextProvider {

    override fun transactionActionProvider(): ITransactionActionProvider =
        stateContext.transactionActionProvider()

    override fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect> =
        stateContext.createStateMachine(initState)

    override fun createStateMachineThenSetToHolder(initState: State) =
        stateContext.createStateMachineThenSetToHolder(initState)

    override fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> =
        stateContext.createStateMachineDefaultState()

    override fun createStateMachineDefaultStateThenSetToHolder() =
        stateContext.createStateMachineDefaultStateThenSetToHolder()

    override fun defaultState(): State = stateContext.defaultState()

    override fun setNewState(state: State) = stateContext.setNewState(state)

    override fun transition(event: Event) {
        stateContext.transition(event)
    }

    override fun getCurrentState(): State {
        return stateContext.getCurrentState()
    }

    override fun getCurrentTransitionData(): TransitionData {
        return stateContext.getCurrentTransitionData()
    }

    override fun setCurrentState(state: State) {
        stateContext.setCurrentState(state)
    }

    override fun setTransitionData(transitionData: TransitionData) {
        stateContext.setTransitionData(transitionData)
    }
}
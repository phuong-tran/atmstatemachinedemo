package com.pt.core1.controller.activity.simple

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.manager.StateMachine
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.context.template.IStateContextDefaultProvider
import com.pt.core1.state.provider.ITransactionActionProvider

/*
abstract class SimpleStateActivity2 : SimpleStateActivity(), IGraphBuilderProvider,
    ITransactionActionProvider, IDefaultStateProvider, IStateContextDefaultProvider {

    final override fun transactionActionProvider(): ITransactionActionProvider =
        stateContext.transactionActionProvider()

    final override fun createStateMachine(initState: State): StateMachine<State, Event, SideEffect> =
        stateContext.createStateMachine(initState)

    final override fun createStateMachineThenSetToHolder(initState: State) =
        stateContext.createStateMachineThenSetToHolder(initState)

    final override fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> =
        stateContext.createStateMachineDefaultState()

    final override fun createStateMachineDefaultStateThenSetToHolder() =
        stateContext.createStateMachineDefaultStateThenSetToHolder()

    final override fun setNewState(state: State) = stateContext.setNewState(state)

    final override fun transition(event: Event) {
        stateContext.transition(event)
    }

    final override fun getCurrentState(): State {
        return stateContext.getCurrentState()
    }

    final override fun getCurrentTransitionData(): TransitionData {
        return stateContext.getCurrentTransitionData()
    }

    final override fun setCurrentState(state: State) {
        stateContext.setCurrentState(state)
    }

    final override fun setTransitionData(transitionData: TransitionData) {
        stateContext.setTransitionData(transitionData)
    }
}*/

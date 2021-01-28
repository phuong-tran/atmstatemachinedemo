package com.pt.core.controller.viewmodel.readonly

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.manager.StateMachine
import com.pt.core.state.provider.template.StateContextReadOnlyProvider
import java.lang.IllegalStateException

abstract class StateReadOnlyViewModelController(stateContext: StateContextReadOnlyProvider) :
    ViewModelBaseWithTransitionListener(), StateContextReadOnlyProvider by stateContext {
    override fun setCurrentState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun setTransitionData(transitionData: TransitionData) {
        throw IllegalStateException("Not Supported")
    }

    override fun setNewState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun getStateMachine(): StateMachine<State, Event, SideEffect> {
        throw IllegalStateException("Not Supported")
    }
}
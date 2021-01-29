package com.pt.core.controller.viewmodel.readonly

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider

abstract class StateReadOnlyViewModelController(stateContext: StateContextReadOnlyStateMachineProvider) :
    ViewModelBaseWithTransitionListener(), StateContextReadOnlyStateMachineProvider by stateContext {
    /*override fun setCurrentState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun setTransitionData(transitionData: TransitionData) {
        throw IllegalStateException("Not Supported")
    }*/

    /*override fun setNewState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun getStateMachine(): StateMachine<State, Event, SideEffect> {
        throw IllegalStateException("Not Supported")
    }*/
}
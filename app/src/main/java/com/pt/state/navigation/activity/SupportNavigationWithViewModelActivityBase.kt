package com.pt.state.navigation.activity

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.navigation.viewmodel.SupportNavigationViewModelBase


abstract class SupportNavigationWithViewModelActivityBase : SupportNavigationActivityBase<State, Event, SideEffect>() {
    // ViewModel Activity Scope
    protected abstract val viewModel: SupportNavigationViewModelBase<State, Event, SideEffect>

    override fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    override fun getCurrentState(): State = viewModel.getCurrentState()

    override fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()
}
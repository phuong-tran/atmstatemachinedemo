package com.pt.state.navigation.fragment

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.manager.StateMachine
import com.pt.state.navigation.viewmodel.SupportNavigationViewModelBase

abstract class SupportNavigationFragmentWithViewModelBase :
    SupportNavigationFragmentBase<State, Event, SideEffect>() {
    protected abstract val viewModel: SupportNavigationViewModelBase<State, Event, SideEffect>

    final override fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    final override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    final override fun getCurrentState(): State = viewModel.getCurrentState()

    final override fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()

    override fun providerStateComposer(): StateMachine<State, Event, SideEffect> =
        viewModel.providerStateComposer()
}
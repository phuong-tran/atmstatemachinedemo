package com.pt.state.navigation.fragment.advance

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.navigation.viewmodel.SupportStateGenericViewModel

abstract class AdvancedStateSupportBaseFragment :
    AdvancedStateSupportGenericFragment<State, Event, SideEffect>() {
    override val TAG: String = "SupportNavigationFragmentWithViewModelBase"
    protected abstract val viewModel: SupportStateGenericViewModel<State, Event, SideEffect>

    final override fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    final override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    final override fun getCurrentState(): State = viewModel.getCurrentState()

    final override fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()
}
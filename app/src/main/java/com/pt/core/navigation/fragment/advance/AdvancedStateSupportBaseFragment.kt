package com.pt.core.navigation.fragment.advance

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionGenericData
import com.pt.core.navigation.viewmodel.statebase.AdvancedSupportStateBaseViewModel

abstract class AdvancedStateSupportBaseFragment :
    AdvancedStateBaseSupportFragment() {
    override val TAG: String = "SupportNavigationFragmentWithViewModelBase"
    protected abstract val viewModel: AdvancedSupportStateBaseViewModel

    final override fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    final override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    final override fun getCurrentState(): State = viewModel.getCurrentState()

    final override fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()
}
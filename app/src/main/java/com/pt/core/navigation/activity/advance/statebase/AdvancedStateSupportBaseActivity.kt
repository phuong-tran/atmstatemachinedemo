package com.pt.core.navigation.activity.advance.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionGenericData
import com.pt.core.navigation.viewmodel.statebase.AdvancedSupportStateBaseViewModel


abstract class AdvancedStateSupportBaseActivity : AdvancedStateBaseSupportActivity() {
    override val TAG = "AdvancedStateSupportBaseActivity"

    // ViewModel Activity Scope
    protected abstract val viewModel: AdvancedSupportStateBaseViewModel

    override fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    override fun getCurrentState(): State = viewModel.getCurrentState()

    override fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()

}
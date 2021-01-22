package com.pt.core.navigation.activity.advance

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionGenericData
import com.pt.core.navigation.viewmodel.generic.SupportStateGenericViewModel


abstract class AdvancedStateSupportBaseActivity :
    AdvancedStateSupportGenericActivity<State, Event, SideEffect>() {
    override val TAG = "AdvancedStateSupportBaseActivity"
    // ViewModel Activity Scope
    protected abstract val viewModel: SupportStateGenericViewModel<State, Event, SideEffect>

    override fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    override fun getCurrentState(): State = viewModel.getCurrentState()

    override fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect> =
        viewModel.getCurrentTransitionData()


    override val stateMachine =
        createStateMachine { fromState: State, event: Event, toState: State, sideEffect: SideEffect? ->
            onTransaction(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        }
}
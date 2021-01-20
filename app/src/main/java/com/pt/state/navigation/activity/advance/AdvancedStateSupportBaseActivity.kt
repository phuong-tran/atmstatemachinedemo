package com.pt.state.navigation.activity.advance

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.navigation.viewmodel.SupportStateGenericViewModel


abstract class AdvancedStateSupportBaseActivity :
    AdvancedStateSupportGenericActivity<State, Event, SideEffect>() {
    // ViewModel Activity Scope
    protected abstract val viewModel: SupportStateGenericViewModel<State, Event, SideEffect>

    override fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        viewModel.saveTransitionData(transitionData)
    }

    override fun saveState(state: State) {
        viewModel.saveState(state)
    }

    override fun getCurrentState(): State = viewModel.getCurrentState()

    override fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect> =
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
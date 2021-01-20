package com.pt.state.navigation.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionGenericData
import com.pt.state.navigation.state.advance.NavigationAdvancedHandler
import com.pt.state.navigation.state.STATE
import com.pt.state.navigation.state.TRANSITION_DATA


abstract class AdvancedSupportStateBaseViewModel(
    navigation: NavigationAdvancedHandler<State, Event, SideEffect>,
    private val savedStateHandle: SavedStateHandle
) : SupportStateGenericViewModel<State, Event, SideEffect>(navigation) {

    override val TAG = "SupportNavigationViewModelWithSavedHandlerBase"

    override fun saveState(state: State) {
        savedStateHandle.set(STATE, state)
        Log.d(TAG, "saveState $state")
    }

    override fun getCurrentState(): State =
        savedStateHandle.get(STATE) ?: stateMachine.state

    override fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>) {
        savedStateHandle.set(TRANSITION_DATA, transitionData)
        Log.d(TAG, "saveTransitionData $transitionData")
    }

    override fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect> {
        return savedStateHandle.get(TRANSITION_DATA)!!
    }

}
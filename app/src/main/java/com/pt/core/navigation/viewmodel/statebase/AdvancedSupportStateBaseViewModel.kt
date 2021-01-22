package com.pt.core.navigation.viewmodel.statebase

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionGenericData
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler


abstract class AdvancedSupportStateBaseViewModel(
    navigation: NavigationAdvancedHandler,
    savedStateHandle: SavedStateHandle
) : SavedStateHandlerBaseViewModel(savedStateHandle), NavigationAdvancedHandler by navigation {

    protected abstract val TAG: String

    override fun saveState(state: State) {
        savedStateHandle.set(STATE, state)
        Log.d(TAG, "saveState $state")
    }

    override fun getCurrentState(): State =
        savedStateHandle.get(STATE) ?: provideStateMachine().state

    override fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>) {
        savedStateHandle.set(TRANSITION_DATA, transitionData)
        Log.d(TAG, "saveTransitionData $transitionData")
    }

    override fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect> {
        return savedStateHandle.get(TRANSITION_DATA)!!
    }

}
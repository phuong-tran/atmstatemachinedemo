package com.pt.core1.state.helper


import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.controller.provider.RestoreStateProvider

/*
fun Bundle.restoreCurrentStateFromBundle(
    restoreStateProvider: RestoreStateProvider,
    defaultState: State
) {
    with(restoreStateProvider) {
        val currentState: State = getParcelable(STATE) ?: defaultState
        restoreCurrentState(currentState)

        val currentTransitionData: TransitionData? = getParcelable(TRANSITION_DATA)
        if (currentTransitionData != null) {
            restoreCurrentTransitionData(currentTransitionData)
        }
    }
}
*/

fun Bundle.saveCurrentStateToBundle(state: State) {
    putParcelable(STATE, state)
}

fun Bundle.saveCurrentTransitionDataToBundle(transitionData: TransitionData) {
    putParcelable(TRANSITION_DATA, transitionData)
}

fun Bundle.saveAllCurrentStateToBundle(state: State, transitionData: TransitionData) {
    saveCurrentStateToBundle(state)
    saveCurrentTransitionDataToBundle(transitionData)
}

fun Bundle.getStateFromBundle(): State? {
    return getParcelable(STATE)
}

fun Bundle.getTransitionDataFromBundle(): TransitionData? {
    return getParcelable(TRANSITION_DATA)
}

fun SavedStateHandle.saveStateToSavedStateHandler(state: State) {
    set(STATE, state)
}

fun SavedStateHandle.saveTransitionDataToSavedStateHandler(
    transitionData: TransitionData
) {
    set(TRANSITION_DATA, transitionData)
}

fun SavedStateHandle.getStateToSavedStateHandler(): State? = get(STATE)

fun SavedStateHandle.saveTransitionDataToToSavedStateHandler(): TransitionData? =
    get(TRANSITION_DATA)
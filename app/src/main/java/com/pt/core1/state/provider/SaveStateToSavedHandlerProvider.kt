package com.pt.core1.state.provider

import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.saveAllCurrentStateToSavedStateHandler

interface SaveStateToSavedHandlerProvider {
    fun saveStateToSavedStateHandler(savedStateHandle: SavedStateHandle, state: State) {
        savedStateHandle.set(STATE, state)
    }

    fun saveTransitionDataToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        transitionData: TransitionData
    ) {
        savedStateHandle.set(TRANSITION_DATA, transitionData)
    }

    fun saveAllCurrentStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        state: State,
        transitionData: TransitionData
    ) {
        savedStateHandle.saveAllCurrentStateToSavedStateHandler(
            state,
            transitionData
        )
    }

    fun saveStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        currentState: CurrentStateGetterProvider
    ) {
        savedStateHandle.set(STATE, currentState.getCurrentState())
    }

    fun saveTransitionDataToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        currentState: CurrentStateGetterProvider
    ) {
        savedStateHandle.set(TRANSITION_DATA, currentState.getCurrentTransitionData())
    }

    fun saveAllCurrentStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        currentState: CurrentStateGetterProvider
    ) {
        with(currentState) {
            savedStateHandle.saveAllCurrentStateToSavedStateHandler(
                getCurrentState(),
                getCurrentTransitionData()
            )
        }
    }
}
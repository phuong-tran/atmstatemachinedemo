package com.pt.core1.state.provider

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface ISaveStateToSavedHandlerProvider {
    fun saveStateToSavedStateHandler(savedStateHandle: SavedStateHandle, state: State)

    fun saveTransitionDataToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        transitionData: TransitionData
    )

    fun saveAllCurrentStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        state: State,
        transitionData: TransitionData
    )
}
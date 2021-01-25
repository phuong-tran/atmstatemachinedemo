package com.pt.core1.state.provider

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
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
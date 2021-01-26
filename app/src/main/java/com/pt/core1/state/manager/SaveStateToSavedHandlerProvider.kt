package com.pt.core1.state.manager

import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.saveAllCurrentStateToSavedStateHandler
import com.pt.core1.state.provider.ISaveStateToSavedHandlerProvider

object SaveStateToSavedHandlerProvider : ISaveStateToSavedHandlerProvider {
    override fun saveStateToSavedStateHandler(savedStateHandle: SavedStateHandle, state: State) {
        savedStateHandle.set(STATE, state)
    }

    override fun saveTransitionDataToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        transitionData: TransitionData
    ) {
        savedStateHandle.set(TRANSITION_DATA, transitionData)
    }

    override fun saveAllCurrentStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        state: State,
        transitionData: TransitionData
    ) {
        savedStateHandle.saveAllCurrentStateToSavedStateHandler(
            state,
            transitionData
        )
    }
}
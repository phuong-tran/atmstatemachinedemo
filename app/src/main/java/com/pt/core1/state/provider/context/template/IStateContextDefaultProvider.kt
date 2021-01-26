package com.pt.core1.state.provider.context.template

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.*
import com.pt.core1.state.provider.*

interface IStateContextDefaultProvider : IMutableStateContextSupportBundleStorageProvider,
    ISaveStateToSavedHandlerProvider {

    override fun saveStateToBundle(bundle: Bundle, state: State) {
        bundle.saveCurrentStateToBundle(state)
    }

    override fun saveTransitionDataToBundle(bundle: Bundle, transitionData: TransitionData) {
        bundle.saveCurrentTransitionDataToBundle(transitionData)
    }

    override fun saveAllCurrentStateToBundle(
        bundle: Bundle,
        state: State,
        transitionData: TransitionData
    ) {
        bundle.saveAllCurrentStateToBundle(state, transitionData)
    }

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
            getCurrentState(),
            getCurrentTransitionData()
        )
    }
}
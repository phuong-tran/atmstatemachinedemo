package com.pt.core1.controller.viewmodel.external.advance

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportWithDelegateViewModel
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.SaveStateViaSavedHandler
import com.pt.core1.state.provider.template.StateContextDefaultProvider

abstract class StateSupportWithDelegateViewModel(
    private val savedStateHandle: SavedStateHandle,
    stateContext: StateContextDefaultProvider
) : SimpleStateSupportWithDelegateViewModel(stateContext), SaveStateViaSavedHandler {

    final override fun saveStateToSavedStateHandler(
        savedStateHandle: SavedStateHandle,
        state: State
    ) {
        super.saveStateToSavedStateHandler(savedStateHandle, state)
    }

    final override fun saveStateToSavedStateHandler(state: State) {
        super.saveStateToSavedStateHandler(savedStateHandle, state)
    }

    final override fun saveTransitionDataToSavedStateHandler(transitionData: TransitionData) {
        super.saveTransitionDataToSavedStateHandler(savedStateHandle, transitionData)
    }

    final override fun saveAllCurrentStateToSavedStateHandler(
        state: State,
        transitionData: TransitionData
    ) {
        super.saveAllCurrentStateToSavedStateHandler(savedStateHandle, state, transitionData)
    }
}

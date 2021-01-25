package com.pt.core1.controller.viewmodel.external.advance

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportViewModel
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.provider.ISaveStateViaSavedHandler
import com.pt.core1.state.provider.IStateContextProvider

abstract class StateSupportViewModel(
    private val savedStateHandle: SavedStateHandle,
    stateContext: IStateContextProvider
) : SimpleStateSupportViewModel(stateContext), ISaveStateViaSavedHandler {

    final override fun saveStateToSavedStateHandler(state: State) {
        stateContext.saveStateToSavedStateHandler(savedStateHandle, state)
    }

    final override fun saveTransitionDataToSavedStateHandler(transitionData: TransitionData) {
        stateContext.saveTransitionDataToSavedStateHandler(savedStateHandle, transitionData)
    }

    final override fun saveAllCurrentStateToSavedStateHandler(
        state: State,
        transitionData: TransitionData
    ) {
        stateContext.saveAllCurrentStateToSavedStateHandler(savedStateHandle, state, transitionData)
    }
}

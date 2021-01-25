package com.pt.core1.state.provider

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.STATE
import com.pt.core.state.TRANSITION_DATA
import com.pt.core1.data.Event
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.saveAllCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentTransitionDataToBundle

interface IStateContextProvider : IStateMachineCreatorProvider {
    fun transactionActionProvider(): ITransactionActionProvider

    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionData

    fun setCurrentState(state: State)
    fun setTransitionData(transitionData: TransitionData)

    fun saveStateToBundle(bundle: Bundle, state: State) {
        bundle.saveCurrentStateToBundle(state)
    }

    fun saveTransitionDataToBundle(bundle: Bundle, transitionData: TransitionData) {
        bundle.saveCurrentTransitionDataToBundle(transitionData)
    }

    fun saveAllCurrentStateToBundle(bundle: Bundle, state: State, transitionData: TransitionData) {
        bundle.saveAllCurrentStateToBundle(state, transitionData)
    }

    fun saveStateToSavedStateHandle(savedStateHandle: SavedStateHandle, state: State) {
        savedStateHandle.set(STATE, state)
    }

    fun saveTransitionDataToToSavedStateHandle(
        savedStateHandle: SavedStateHandle,
        transitionData: TransitionData
    ) {
        savedStateHandle.set(TRANSITION_DATA, transitionData)
    }

    fun setNewState(state: State)

    fun transition(event: Event)
}
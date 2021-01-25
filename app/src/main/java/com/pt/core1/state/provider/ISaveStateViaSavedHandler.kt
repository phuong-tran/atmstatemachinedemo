package com.pt.core1.state.provider

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface ISaveStateViaSavedHandler {
    fun saveStateToSavedStateHandler(state: State)
    fun saveTransitionDataToSavedStateHandler(transitionData: TransitionData)
    fun saveAllCurrentStateToSavedStateHandler(state: State, transitionData: TransitionData)
}
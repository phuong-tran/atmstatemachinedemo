package com.pt.core1.state.provider

import android.os.Bundle
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.saveAllCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentTransitionDataToBundle

interface SaveStateToBundleProvider {
    fun saveStateToBundle(bundle: Bundle, state: State) {
        bundle.saveCurrentStateToBundle(state)
    }

    fun saveTransitionDataToBundle(bundle: Bundle, transitionData: TransitionData) {
        bundle.saveCurrentTransitionDataToBundle(transitionData)
    }

    fun saveAllCurrentStateToBundle(
        bundle: Bundle,
        state: State,
        transitionData: TransitionData
    ) {
        bundle.saveAllCurrentStateToBundle(state, transitionData)
    }

    fun saveStateToBundle(bundle: Bundle, currentState: CurrentStateGetterProvider) {
        bundle.saveCurrentStateToBundle(currentState.getCurrentState())
    }

    fun saveTransitionDataToBundle(bundle: Bundle, currentState: CurrentStateGetterProvider) {
        bundle.saveCurrentTransitionDataToBundle(currentState.getCurrentTransitionData())
    }

    fun saveAllCurrentStateToBundle(
        bundle: Bundle,
        currentState: CurrentStateGetterProvider
    ) {
        with(currentState) {
            bundle.saveAllCurrentStateToBundle(
                getCurrentState(),
                getCurrentTransitionData()
            )
        }
    }
}
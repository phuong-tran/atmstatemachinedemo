package com.pt.core1.state.provider

import android.os.Bundle
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData

interface SaveStateToBundleProvider {
    fun saveStateToBundle(bundle: Bundle, state: State)
    fun saveTransitionDataToBundle(bundle: Bundle, transitionData: TransitionData)
    fun saveAllCurrentStateToBundle(bundle: Bundle, state: State, transitionData: TransitionData)
}
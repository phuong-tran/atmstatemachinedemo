package com.pt.core1.state.manager

import android.os.Bundle
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.helper.saveAllCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentStateToBundle
import com.pt.core1.state.helper.saveCurrentTransitionDataToBundle
import com.pt.core1.state.provider.ISaveStateToBundleProvider

object SaveStateToBundleProvider : ISaveStateToBundleProvider {
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
}
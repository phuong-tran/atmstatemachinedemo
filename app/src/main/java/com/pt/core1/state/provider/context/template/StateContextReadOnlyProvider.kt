package com.pt.core1.state.provider.context.template

import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import java.lang.IllegalStateException

interface StateContextReadOnlyProvider : StateContextProvider {
    override fun setCurrentState(state: State) {
        throw IllegalStateException("Not Supported")
    }

    override fun setTransitionData(transitionData: TransitionData) {
        throw IllegalStateException("Not Supported")
    }

    override fun setNewState(state: State) {
        throw IllegalStateException("Not Supported")
    }
}
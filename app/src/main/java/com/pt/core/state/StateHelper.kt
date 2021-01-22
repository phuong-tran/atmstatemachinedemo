package com.pt.core.state

import android.os.Bundle
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.common.generic.StateTransitionGenericProvider
import com.pt.core.state.manual.generic.update.UpdateStateHandler

fun Bundle.restoreState(updateStateHandler: UpdateStateHandler, defaultState: State) {
    with(updateStateHandler) {
        setCurrentState((getParcelable(STATE) ?: defaultState).also {
            setCurrentState(it)
        })
        getParcelable<TransitionData>(TRANSITION_DATA)?.let {
            setCurrentTransitionData(it)
        }
    }
}

fun Bundle.saveState(defaultState: State, transitionData: TransitionData) {
    putParcelable(STATE, defaultState)
    putParcelable(TRANSITION_DATA, transitionData)
}

fun <S : State, E : Event, SF : SideEffect> setDefaultState(
    updateStateHandler: UpdateStateHandler, defaultState: S,
    stateProvider: StateTransitionGenericProvider<S, E, SF>
) {
    updateStateHandler.setCurrentState(defaultState)
    stateProvider.givenState(defaultState)
}
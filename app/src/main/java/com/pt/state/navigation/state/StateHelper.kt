package com.pt.state.navigation.state

import android.os.Bundle
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.navigation.state.common.StateTransitionGenericProvider
import com.pt.state.navigation.state.manual.update.UpdateStateHandler

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
package com.pt.state.navigation.activity.basic

import android.os.Bundle
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.navigation.state.*
import com.pt.state.navigation.state.manual.ManualSavedStateHandler
import com.pt.state.navigation.state.manual.update.UpdateStateHandler
import java.util.concurrent.atomic.AtomicReference

abstract class BasicStateSupportBaseActivity :
    BasicStateSupportGenericActivity<State, Event, SideEffect>(), ManualSavedStateHandler,
    UpdateStateHandler {

    override val currentState: AtomicReference<State> = AtomicReference(defaultState)
    override val currentTransitionData: AtomicReference<TransitionData> = AtomicReference()

    override fun setCurrentState(state: State) = currentState.set(state)
    override fun getCurrentState(): State = currentState.get()

    override fun getCurrentTransitionData(): TransitionData =
        currentTransitionData.get()

    override fun setCurrentTransitionData(transitionData: TransitionData) =
        currentTransitionData.set(transitionData)


    override val stateMachine =
        createStateMachine { fromState: State, event: Event, toState: State, sideEffect: SideEffect? ->
            onTransaction(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        }

    override fun onTransaction(
        fromState: State,
        event: Event,
        toState: State,
        sideEffect: SideEffect?
    ) {
        currentTransitionData.set(
            TransitionData(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        with(outState) {
            super.onSaveInstanceState(this)
            saveState(defaultState = defaultState, transitionData = getCurrentTransitionData())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            savedInstanceState.restoreState(this, defaultState)
        } else {
            setDefaultState(this, defaultState, this)
        }
    }
}
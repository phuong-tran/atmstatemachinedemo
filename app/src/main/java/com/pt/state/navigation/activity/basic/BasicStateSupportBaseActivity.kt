package com.pt.state.navigation.activity.basic

import android.os.Bundle
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.navigation.ManualSavedStateHandler
import com.pt.state.navigation.STATE
import com.pt.state.navigation.TRANSITION_DATA
import java.util.concurrent.atomic.AtomicReference

abstract class BasicStateSupportBaseActivity :
    BasicStateSupportGenericActivity<State, Event, SideEffect>(), ManualSavedStateHandler {

    override val currentState: AtomicReference<State> = AtomicReference(defaultState)
    override val currentTransitionData: AtomicReference<TransitionData> = AtomicReference()

    private fun setCurrentState(state: State) = currentState.set(state)
    override fun getCurrentState(): State = currentState.get()

    override fun getCurrentTransitionData(): TransitionData =
        currentTransitionData.get()

    private fun setCurrentTransitionData(transitionData: TransitionData) =
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
            putParcelable(STATE, defaultState)
            putParcelable(TRANSITION_DATA, getCurrentTransitionData())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            with(savedInstanceState) {
                setCurrentState((getParcelable(STATE) ?: defaultState).also {
                    setCurrentState(it)
                })
                getParcelable<TransitionData>(TRANSITION_DATA)?.let {
                    setCurrentTransitionData(it)
                }
            }
        } else {
            setDefaultState()
        }
    }

    private fun setDefaultState() {
        setCurrentState(defaultState)
        givenState(state = defaultState)
    }
}
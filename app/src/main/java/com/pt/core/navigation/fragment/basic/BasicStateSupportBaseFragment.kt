package com.pt.core.navigation.fragment.basic

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.restoreState
import com.pt.core.state.saveState
import com.pt.core.state.setDefaultState
import com.pt.core.state.manual.ManualSavedStateHandler
import com.pt.core.state.manual.update.UpdateStateHandler
import java.util.concurrent.atomic.AtomicReference

abstract class BasicStateSupportBaseFragment :
    BasicStateSupportGenericFragment<State, Event, SideEffect>(),
    ManualSavedStateHandler, UpdateStateHandler {
    override val TAG = "SupportNavigationStandAloneFragment"

    /**
     * The state may be changed in some cases, such as using the same fragment (screen), but not same state
     */

    override val currentState: AtomicReference<State> = AtomicReference(defaultState)
    override val currentTransitionData: AtomicReference<TransitionData> = AtomicReference()

    override fun setCurrentState(state: State) = currentState.set(state)

    override fun setCurrentTransitionData(transitionData: TransitionData) =
        currentTransitionData.set(transitionData)

    override fun getCurrentState(): State = currentState.get()

    override fun getCurrentTransitionData(): TransitionData =
        currentTransitionData.get()


    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Set default state here
        givenState(state = defaultState)
    }

    override val stateMachine =
        createStateMachine { fromState: State, event: Event, toState: State, sideEffect: SideEffect? ->
            onTransaction(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        }

    @CallSuper
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
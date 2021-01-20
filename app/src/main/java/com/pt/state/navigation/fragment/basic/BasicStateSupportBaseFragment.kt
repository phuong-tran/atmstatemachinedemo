package com.pt.state.navigation.fragment.basic

import android.content.Context
import android.os.Bundle
import androidx.annotation.CallSuper
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.navigation.STATE
import com.pt.state.navigation.TRANSITION_DATA
import java.util.concurrent.atomic.AtomicReference

abstract class BasicStateSupportBaseFragment :
    BasicStateSupportGenericFragment<State, Event, SideEffect>() {
    override val TAG = "SupportNavigationStandAloneFragment"
    /**
     * The state may be changed in some cases, such as using the same fragment (screen), but not same state
     */
    protected abstract val defaultState: State

    private val currentTransitionData =
        AtomicReference<TransitionData>()
    private val currentState = AtomicReference<State>()

    private fun setCurrentState(state: State) = currentState.set(state)

    override fun getCurrentState(): State = currentState.get()

    override fun getCurrentTransitionData(): TransitionData =
        currentTransitionData.get()

    private fun setCurrentTransitionData(transitionData: TransitionData) =
        currentTransitionData.set(transitionData)

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
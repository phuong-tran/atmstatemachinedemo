package com.pt.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels

import com.pt.app.state.manager.provideGraph
import com.pt.app.state.manager.state.States
import com.pt.app.state.manager.event.Events
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.navigation.activity.advance.statebase.AdvancedStateSupportBaseActivity
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R

class MainActivity : AdvancedStateSupportBaseActivity() {
    override val TAG = "MainActivity"

    override val viewModel: SupportNavigationViewModelWithSavedHandler by viewModels {
        SupportNavigationViewModelWithSavedHandler.Factory(navigation = this, this)
    }

    override fun initializeStateMachine(): StateMachine<State, Event, SideEffect> {
        return createStateMachine(States.IDLE) { fromState: State, event: Event, toState: State, sideEffect: SideEffect? ->
            onTransaction(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        }
    }

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> =
        provideGraph().apply {
            initialState(States.IDLE)
        }

    override fun onTransaction(
        fromState: State,
        event: Event,
        toState: State,
        sideEffect: SideEffect?
    ) {
        viewModel.onTransit(
            TransitionData(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        )
        when (fromState) {
            is States.IDLE -> {
                Log.d(TAG, "from $fromState")
            }
            else -> {
                Log.d(TAG, "fromState Not Handle")
            }
        }

        when (toState) {
            is States.VerifyCart -> {
                Log.d(TAG, "from $toState")
            }
            else -> {
                Log.d(TAG, "toState Not Handle")
            }
        }
    }

    private fun registerTransitionObserver() {
        viewModel.transitionData.observe(this, {
            Log.d(TAG, "at registerTransitionObserver = $it")
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerTransitionObserver()
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            givenState(States.IDLE)
            transition(com.pt.app.state.manager.event.Events.InsertCard)
            Log.d(TAG, "currentStateA = ${viewModel.getCurrentState()}")
            Log.d(TAG, "currentTransactionDataA = ${viewModel.getCurrentTransitionData()}")
        } else {
            Log.d(TAG, "currentStateB = ${viewModel.getCurrentState()}")
            Log.d(TAG, "currentTransactionDataB = ${viewModel.getCurrentTransitionData()}")
            setStateWith(viewModel.getCurrentTransitionData().fromState)
            transition(Events.InsertCard)
        }
    }
}
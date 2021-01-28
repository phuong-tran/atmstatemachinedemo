package com.pt.app.activity


import android.os.Bundle
import android.util.Log
import com.pt.app.graph.event.Events
import com.pt.app.graph.provideGraph
import com.pt.app.graph.state.States
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateFullActivityController
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R

class MainActivity : StateFullActivityController() {
    override val TAG = "MainActivity"

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        return provideGraph()
    }

    override fun onTransaction(transitionData: TransitionData) {
        when (transitionData.fromState) {
            is States.IDLE -> {
                Log.d(TAG, "from ${transitionData.fromState}")
            }
            else -> {
                Log.d(TAG, "fromState Not Handle")
            }
        }

        when (transitionData.toState) {
            is States.VerifyCart -> {
                Log.d(TAG, "toState ${transitionData.toState}")
            }
            else -> {
                Log.d(TAG, "toState Not Handle")
            }
        }
    }

    override fun provideDefaultState(): State = States.IDLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test1(savedInstanceState)
    }

    private fun test1(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            stateContext.transition(Events.InsertCard)
            Log.d(TAG, " currentState = " + stateContext.getCurrentState())
            Log.d(
                TAG,
                " currentStateTransitionData = " + stateContext.getCurrentTransitionData()
            )
        } else {
            Log.d(TAG, " currentStateB = " + stateContext.getCurrentState())
            Log.d(
                TAG,
                " currentStateTransitionDataB = " + stateContext.getCurrentTransitionData()
            )
        }
    }
}
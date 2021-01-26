package com.pt.app1.activity

import android.os.Bundle
import android.util.Log
import com.pt.app1.graph.event.Events
import com.pt.app1.graph.provideGraph
import com.pt.app1.graph.state.States
import com.pt.core1.controller.activity.simple.SimpleStateActivity2
import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.manager.StateContextDefaultProvider
import com.pt.core1.state.manager.StateMachine
import com.pt.dig.atm.R

class MainActivity : SimpleStateActivity2() {
    override val TAG = "MainActivity"

    override val stateContext =
        StateContextDefaultProvider.createStateContextProvider(this, this, this)



    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> =
        provideGraph()

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

    override fun defaultState(): State = States.IDLE

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
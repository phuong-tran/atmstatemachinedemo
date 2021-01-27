package com.pt.app1.activity


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pt.dig.atm.R
import com.pt.helper.delegate.BundleDelegate
import com.pt.helper.delegate.asDelegate
import com.pt.helper.delegate.bundleDelegate

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    //override val TAG = "MainActivity"

    /*override val stateContext =
        StateContextDefaultProvider.createStateContextProvider(this, this, this)*/


    /*override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> =
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
    }*/
}
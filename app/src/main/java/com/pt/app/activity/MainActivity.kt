package com.pt.app.activity


import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.pt.app.graph.event.Events
import com.pt.app.graph.provideGraph
import com.pt.app.graph.state.States
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StandAloneStateFullActivityController
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : StandAloneStateFullActivityController(),
    BottomNavigationView.OnNavigationItemReselectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    override val TAG = "MainActivity"

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "Hello onNavigationItemSelected ${item.itemId} - ${item.title}")
        return true
    }

    override fun onNavigationItemReselected(item: MenuItem) {
        Log.d(TAG, "Hello onNavigationItemReselected ${item.itemId} - ${item.title}")
    }

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
        nav_view.itemTextColor = ColorStateList.valueOf(Color.BLACK)
        nav_view.setOnNavigationItemReselectedListener(this)
        nav_view.setOnNavigationItemSelectedListener(this)
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
        }
    }
}
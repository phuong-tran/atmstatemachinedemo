package com.pt.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.provideGraph
import com.pt.app.state.manager.state.States
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.dig.atm.R
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.manager.StateMachine
import com.pt.state.navigation.activity.advance.SupportNavigationWithViewModelActivityBase

class MainActivity : SupportNavigationWithViewModelActivityBase() {
    // ViewModel Activity Scope
    override val viewModel: SupportNavigationViewModelWithSavedHandler by viewModels {
        SupportNavigationViewModelWithSavedHandler.Factory(navigation = this, this)
    }

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> =
        provideGraph()

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
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.transitionData.observe(this, {
            Log.d("PHUONGTRAN", "transitionData Api = $it")
        })
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {

        }
        givenState(States.IDLE.get())
        transition(Events.InsertCard.get())

    }
}
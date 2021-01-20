package com.pt.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.provideGraph
import com.pt.app.state.manager.state.States
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.dig.atm.R
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.manager.StateMachine
import com.pt.core.navigation.activity.advance.AdvancedStateSupportBaseActivity

class MainActivity : AdvancedStateSupportBaseActivity() {
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
        /*viewModel.transitionData.observe(this, {
            Log.d("PHUONGTRAN", "transitionData Api = $it")

        })*/
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            givenState(States.IDLE.get())
            transition(Events.InsertCard.get())
            Log.d("PHUONGTRAN", "currentStateA = ${viewModel.getCurrentState()}")
            Log.d("PHUONGTRAN", "currentTransactionDataA = ${viewModel.getCurrentTransitionData()}")
        } else {
            Log.d("PHUONGTRAN", "currentStateB = ${viewModel.getCurrentState()}")
            Log.d("PHUONGTRAN", "currentTransactionDataB = ${viewModel.getCurrentTransitionData()}")
        }
    }
}
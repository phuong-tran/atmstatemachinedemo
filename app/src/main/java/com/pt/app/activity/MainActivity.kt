package com.pt.app.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.state.States
import com.pt.app.state.manager.stateMachineProvider
import com.pt.dig.atm.R
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.manager.StateMachine
import com.pt.state.navigation.activity.SupportNavigationWithViewModelActivityBase
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.state.data.transition.TransitionData

class MainActivity : SupportNavigationWithViewModelActivityBase() {
    // ViewModel Activity Scope
    override val viewModel: SupportNavigationViewModelWithSavedHandler by viewModels {
        SupportNavigationViewModelWithSavedHandler.Factory(navigation = this, this)
    }

    override fun providerStateComposer(): StateMachine<State, Event, SideEffect> = stateMachineProvider {
        doOnTransition(it)
    }

    override fun doOnTransition(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        super.doOnTransition(transitionData)
        Log.d("PHUONGTRAN", "transitionData = $transitionData")
        viewModel.onTransit(transitionData as TransitionData)
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
package com.pt.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.dig.atm.R
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.manager.StateMachine
import com.pt.state.navigation.fragment.SupportNavigationFragmentWithViewModelBase

class IntroFragment : SupportNavigationFragmentWithViewModelBase() {

    override val viewModel: SupportNavigationViewModelWithSavedHandler by activityViewModels() {
        SupportNavigationViewModelWithSavedHandler.Factory(navigation = this, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intro_layout, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.transitionData.observe(viewLifecycleOwner, {

        })
    }

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        TODO("Not yet implemented")
    }

    override fun onTransaction(
        fromState: State,
        event: Event,
        toState: State,
        sideEffect: SideEffect?
    ) {
        TODO("Not yet implemented")
    }

    override val stateMachine: StateMachine<State, Event, SideEffect>
        get() = TODO("Not yet implemented")
}
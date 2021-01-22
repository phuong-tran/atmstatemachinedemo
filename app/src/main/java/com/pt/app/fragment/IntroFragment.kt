package com.pt.app.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.pt.app.viewmodel.SupportNavigationViewModelWithSavedHandler
import com.pt.dig.atm.R
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine
import com.pt.core.navigation.fragment.advance.AdvancedStateSupportBaseFragment
import com.pt.core.navigation.viewmodel.statebase.AdvancedSupportStateBaseViewModel

class IntroFragment : AdvancedStateSupportBaseFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intro_layout, container, false)
    }

    override val viewModel: SupportNavigationViewModelWithSavedHandler by activityViewModels() {
        SupportNavigationViewModelWithSavedHandler.Factory(navigation = this, this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.transitionData.observe(viewLifecycleOwner, {

        })
    }


    override fun onTransaction(
        fromState: State,
        event: Event,
        toState: State,
        sideEffect: SideEffect?
    ) {
        TODO("Not yet implemented")
    }

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        TODO("Not yet implemented")
    }


    override fun provideStateMachine(): StateMachine<State, Event, SideEffect> {
        TODO("Not yet implemented")
    }
}
package com.pt.core.navigation.activity.advance.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.activity.AppCompatActivityWithStateHolderBase
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler
import com.pt.core.state.manager.StateMachine

abstract class AdvancedStateBaseSupportActivity : AppCompatActivityWithStateHolderBase(),
    NavigationAdvancedHandler {
    override fun provideStateMachine(): StateMachine<State, Event, SideEffect> = getStateMachine()
}


package com.pt.core.navigation.fragment.advance

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.fragment.FragmentBase
import com.pt.core.navigation.stateholder.statebase.StateHolder
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler
import com.pt.core.state.manager.StateMachine
import java.util.concurrent.atomic.AtomicReference

abstract class AdvancedStateBaseSupportFragment : FragmentBase(), NavigationAdvancedHandler,
    StateHolder {
    override val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>> =
        AtomicReference(initializeStateMachine())
}
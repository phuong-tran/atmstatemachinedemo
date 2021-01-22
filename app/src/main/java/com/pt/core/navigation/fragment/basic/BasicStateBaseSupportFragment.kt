package com.pt.core.navigation.fragment.basic

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.fragment.FragmentBase
import com.pt.core.navigation.stateholder.statebase.StateHolder
import com.pt.core.state.manager.StateMachine
import com.pt.core.state.manual.statebase.NavigationSimpleHandler
import java.util.concurrent.atomic.AtomicReference

abstract class BasicStateBaseSupportFragment : FragmentBase(),  NavigationSimpleHandler, StateHolder {
    override val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>> =
        AtomicReference(initializeStateMachine())
}
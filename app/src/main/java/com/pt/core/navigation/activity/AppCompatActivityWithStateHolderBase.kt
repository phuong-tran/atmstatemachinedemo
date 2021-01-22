package com.pt.core.navigation.activity

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.stateholder.statebase.StateHolder
import com.pt.core.state.manager.StateMachine
import java.util.concurrent.atomic.AtomicReference

abstract class AppCompatActivityWithStateHolderBase : AppCompatActivityBase(), StateHolder {
    override val TAG: String = "AppCompatActivityWithStateHolderBase"
    override val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>> =
        AtomicReference(initializeStateMachine())
}
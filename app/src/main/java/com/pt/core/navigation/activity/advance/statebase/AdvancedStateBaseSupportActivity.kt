package com.pt.core.navigation.activity.advance.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.activity.BaseAppCompatActivity
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler
import com.pt.core.state.manager.StateMachine
import java.util.concurrent.atomic.AtomicReference

abstract class AdvancedStateBaseSupportActivity : BaseAppCompatActivity(),
    NavigationAdvancedHandler {

    private val stateMachineHolder: AtomicReference<StateMachine<State, Event, SideEffect>> =
        AtomicReference(createStateMachine { fromState: State, event: Event, toState: State, sideEffect: SideEffect? ->
            onTransaction(
                fromState = fromState,
                event = event,
                toState = toState,
                sideEffect = sideEffect
            )
        })

    protected fun setStateWith(state: State) {
        val newStateMachine = stateMachineHolder.get().with {
            initialState(state)
        }
        stateMachineHolder.set(newStateMachine)
    }

    override fun provideStateMachine(): StateMachine<State, Event, SideEffect> =
        stateMachineHolder.get()
}


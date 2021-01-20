package com.pt.state.navigation.state.common

import android.os.Parcelable
import com.pt.state.manager.StateMachine

interface StateMachineGenericProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    // Expose this, due to we can not initialize this in interface
    // this'll be initialized like this stateMachine = createStateMachine()
    val stateMachine: StateMachine<State, Event, SideEffect>
    fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect>

    fun createStateMachine(onTransaction: (fromState: State, event: Event, toState: State, sideEffect: SideEffect?) -> Unit): StateMachine<State, Event, SideEffect> {
        return StateMachine.createWithDelegate(
            provideGraphBuilder()
        ) { fromState, event, toState, sideEffect ->
            onTransaction(fromState, event, toState, sideEffect)
        }
    }
}
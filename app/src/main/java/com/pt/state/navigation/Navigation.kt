package com.pt.state.navigation

import android.os.Parcelable
import com.pt.state.data.transition.TransitionData
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.manager.StateMachine

interface TransitionHandler {
    fun onTransit(data: TransitionData)
}

interface StateMachineProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
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

interface StateTransitionProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateMachineProvider<State, Event, SideEffect> {
    fun givenState(
        state: State
    ): StateMachine<State, Event, SideEffect> {
        return stateMachine.with { initialState(state) }
    }

    fun transition(event: Event) {
        stateMachine.transition(event)
    }

    fun onTransaction(fromState: State, event: Event, toState: State, sideEffect: SideEffect?)
}

interface CurrentStateProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect>
}

interface StateSavedStateHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    CurrentStateProvider<State, Event, SideEffect> {
    fun saveState(state: State)
    fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>)
}

interface Navigation<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionProvider<State, Event, SideEffect>,
    StateSavedStateHandler<State, Event, SideEffect>

interface NavigationSimple<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionProvider<State, Event, SideEffect>, CurrentStateProvider<State, Event, SideEffect>
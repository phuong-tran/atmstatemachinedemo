package com.pt.state.navigation

import android.os.Parcelable
import androidx.annotation.CallSuper
import com.pt.state.data.transition.TransitionDataBase
import com.pt.state.manager.StateMachine

interface StateProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    fun providerStateComposer(): StateMachine<State, Event, SideEffect>
}

interface StateStorageManager<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {

    fun saveState(state: State)

    fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>)

    fun getCurrentState(): State

    fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect>
}

interface TransitionAction<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateProvider<State, Event, SideEffect> {

    fun givenState(
        state: State
    ): StateMachine<State, Event, SideEffect> {
        return providerStateComposer().with { initialState(state) }
    }

    fun transition(event: Event) {
        providerStateComposer().transition(event)
    }
}

interface OnTransitAction<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateStorageManager<State, Event, SideEffect> {

    @CallSuper
    fun doOnTransition(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        saveState(transitionData.toState)
        saveTransitionData(transitionData)
    }
}

interface Navigation<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateProvider<State, Event, SideEffect>,
    OnTransitAction<State, Event, SideEffect>,
    TransitionAction<State, Event, SideEffect>


/*
interface Navigation<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    fun providerStateComposer(): StateMachine<State, Event, SideEffect>

    fun givenState(state: State): StateMachine<State, Event, SideEffect> {
        return providerStateComposer().with { initialState(state) }
    }

    fun transitTo(event: Event) {
        providerStateComposer().transition(event)
    }

    fun saveState(state: State)

    fun saveTransitionData(transitionData: TransitionDataBase<State, Event, State, SideEffect>)

    fun getCurrentState(): State

    @CallSuper
    fun doOnTransition(transitionData: TransitionDataBase<State, Event, State, SideEffect>) {
        saveState(transitionData.toState)
        saveTransitionData(transitionData)
    }

    fun getCurrentTransitionData(): TransitionDataBase<State, Event, State, SideEffect>
}
*/

package com.pt.state.navigation

import android.os.Parcelable
import com.pt.state.data.transition.TransitionGenericData
import com.pt.state.manager.StateMachine

inline fun <State : Parcelable, Event : Parcelable, SideEffect : Parcelable> stateMachineProvider(
    crossinline doTransition: (transitionData: TransitionGenericData<State, State, Event, SideEffect>) -> Unit,

    ): StateMachine<State, Event, SideEffect> {
    TODO()
}
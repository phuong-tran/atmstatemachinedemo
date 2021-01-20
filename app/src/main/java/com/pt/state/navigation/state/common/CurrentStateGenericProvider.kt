package com.pt.state.navigation.state.common

import android.os.Parcelable
import com.pt.state.data.transition.TransitionGenericData

interface CurrentStateGenericProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect>
}

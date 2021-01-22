package com.pt.core.state.common.generic

import android.os.Parcelable
import com.pt.core.data.transition.TransitionGenericData

interface SavedStateGenericHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    CurrentStateGenericProvider<State, Event, SideEffect> {
    fun saveState(state: State)
    fun saveTransitionData(transitionData: TransitionGenericData<State, Event, State, SideEffect>)
}
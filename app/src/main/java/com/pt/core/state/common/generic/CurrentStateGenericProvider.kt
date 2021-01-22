package com.pt.core.state.common.generic

import android.os.Parcelable
import com.pt.core.data.transition.TransitionGenericData

interface CurrentStateGenericProvider<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> {
    fun getCurrentState(): State
    fun getCurrentTransitionData(): TransitionGenericData<State, Event, State, SideEffect>
}

package com.pt.core.data.transition

import android.os.Parcelable
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransitionData(
    override val fromState: State,
    override val event: Event,
    override val toState: State,
    override val sideEffect: SideEffect?
) : TransitionGenericData<State, Event, State, SideEffect>, Parcelable
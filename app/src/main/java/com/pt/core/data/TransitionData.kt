package com.pt.core.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransitionData(
    val fromState: State,
    val event: Event,
    val toState: State,
    val sideEffect: SideEffect?,
    val currentState: State = toState,
): Parcelable
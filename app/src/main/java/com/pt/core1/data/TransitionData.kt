package com.pt.core1.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TransitionData(
    val fromState: State,
    val event: Event,
    val toState: State,
    val sideEffect: SideEffect?
): Parcelable
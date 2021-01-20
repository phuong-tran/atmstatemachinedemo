package com.pt.state.data.transition

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
interface TransitionDataBase<FromState : Parcelable, Event : Parcelable, ToState : Parcelable, SideEffect : Parcelable> {
    val fromState: FromState
    val event: Event
    val toState: ToState
    val sideEffect: SideEffect?
}
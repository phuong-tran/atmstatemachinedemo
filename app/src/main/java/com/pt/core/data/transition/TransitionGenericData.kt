package com.pt.core.data.transition

import android.os.Parcelable


interface TransitionGenericData<FromState : Parcelable, Event : Parcelable, ToState : Parcelable, SideEffect : Parcelable> {
    val fromState: FromState
    val event: Event
    val toState: ToState
    val sideEffect: SideEffect?
}
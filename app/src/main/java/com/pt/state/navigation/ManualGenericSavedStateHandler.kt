package com.pt.state.navigation

import android.os.Parcelable
import java.util.concurrent.atomic.AtomicReference

interface ManualGenericSavedStateHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateSavedStateHandler<State, Event, SideEffect> {
    val currentState: AtomicReference<State>
    val defaultState: State
}
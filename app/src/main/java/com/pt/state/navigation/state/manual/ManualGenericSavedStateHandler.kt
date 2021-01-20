package com.pt.state.navigation.state.manual

import android.os.Parcelable
import com.pt.state.navigation.state.common.SavedStateGenericHandler
import java.util.concurrent.atomic.AtomicReference

interface ManualGenericSavedStateHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    SavedStateGenericHandler<State, Event, SideEffect>, DefaultGenericStateProvider<State> {
    val currentState: AtomicReference<State>
}
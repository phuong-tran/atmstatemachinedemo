package com.pt.core.state.manual.generic

import android.os.Parcelable
import com.pt.core.state.common.generic.SavedStateGenericHandler
import java.util.concurrent.atomic.AtomicReference

interface ManualGenericSavedStateHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    SavedStateGenericHandler<State, Event, SideEffect>, DefaultGenericStateProvider<State> {
    val currentState: AtomicReference<State>
}
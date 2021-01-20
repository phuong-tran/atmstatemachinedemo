package com.pt.state.navigation

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.data.transition.TransitionGenericData
import java.util.concurrent.atomic.AtomicReference

interface ManualSavedStateHandler : ManualGenericSavedStateHandler<State, Event, SideEffect> {
    val currentTransitionData: AtomicReference<TransitionData>
}
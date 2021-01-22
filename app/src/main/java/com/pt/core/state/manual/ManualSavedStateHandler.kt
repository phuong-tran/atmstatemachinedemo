package com.pt.core.state.manual

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.manual.generic.ManualGenericSavedStateHandler
import java.util.concurrent.atomic.AtomicReference

interface ManualSavedStateHandler : ManualGenericSavedStateHandler<State, Event, SideEffect> {
    val currentTransitionData: AtomicReference<TransitionData>
}
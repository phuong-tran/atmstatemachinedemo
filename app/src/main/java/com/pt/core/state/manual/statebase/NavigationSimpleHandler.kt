package com.pt.core.state.manual.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manual.generic.NavigationSimpleGenericHandler

interface NavigationSimpleHandler : NavigationSimpleGenericHandler<State, Event, SideEffect>
package com.pt.core.navigation.stateholder.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.navigation.stateholder.generic.StateGenericHolder

interface StateHolder : StateGenericHolder<State, Event, SideEffect>
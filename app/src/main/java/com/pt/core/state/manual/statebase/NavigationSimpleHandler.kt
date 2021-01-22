package com.pt.core.state.manual.statebase

import android.os.Parcelable
import com.pt.core.state.common.generic.CurrentStateGenericProvider
import com.pt.core.state.common.generic.StateTransitionGenericProvider

interface NavigationSimpleHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    CurrentStateGenericProvider<State, Event, SideEffect>
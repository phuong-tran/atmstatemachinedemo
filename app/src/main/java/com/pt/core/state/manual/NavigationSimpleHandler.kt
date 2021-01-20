package com.pt.core.state.manual

import android.os.Parcelable
import com.pt.core.state.common.CurrentStateGenericProvider
import com.pt.core.state.common.StateTransitionGenericProvider

interface NavigationSimpleHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    CurrentStateGenericProvider<State, Event, SideEffect>
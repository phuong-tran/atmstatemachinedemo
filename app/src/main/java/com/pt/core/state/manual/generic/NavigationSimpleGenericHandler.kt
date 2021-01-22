package com.pt.core.state.manual.generic

import android.os.Parcelable
import com.pt.core.state.common.generic.CurrentStateGenericProvider
import com.pt.core.state.common.generic.StateTransitionGenericProvider

interface NavigationSimpleGenericHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    CurrentStateGenericProvider<State, Event, SideEffect>
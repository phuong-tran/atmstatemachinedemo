package com.pt.state.navigation.state.manual

import android.os.Parcelable
import com.pt.state.navigation.state.common.CurrentStateGenericProvider
import com.pt.state.navigation.state.common.StateTransitionGenericProvider

interface NavigationSimpleHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    CurrentStateGenericProvider<State, Event, SideEffect>
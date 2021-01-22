package com.pt.core.state.advance

import android.os.Parcelable
import com.pt.core.state.common.SavedStateGenericHandler
import com.pt.core.state.common.StateTransitionGenericProvider

/*
interface NavigationAdvancedHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>*/


interface NavigationAdvancedHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>
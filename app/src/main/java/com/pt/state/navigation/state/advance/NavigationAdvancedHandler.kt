package com.pt.state.navigation.state.advance

import android.os.Parcelable
import com.pt.state.navigation.state.common.SavedStateGenericHandler
import com.pt.state.navigation.state.common.StateTransitionGenericProvider

interface NavigationAdvancedHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>
package com.pt.core.state.advance.generic

import android.os.Parcelable
import com.pt.core.state.common.SavedStateGenericHandler
import com.pt.core.state.common.StateTransitionGenericProvider

interface NavigationAdvancedGenericHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>
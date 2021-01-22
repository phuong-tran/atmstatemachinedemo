package com.pt.core.state.advance.generic

import android.os.Parcelable
import com.pt.core.state.common.generic.SavedStateGenericHandler
import com.pt.core.state.common.generic.StateTransitionGenericProvider
import com.pt.core.state.manual.generic.DefaultGenericStateProvider

interface NavigationAdvancedGenericHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>
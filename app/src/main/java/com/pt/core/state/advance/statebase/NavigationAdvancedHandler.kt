package com.pt.core.state.advance.statebase

import android.os.Parcelable
import com.pt.core.state.common.generic.SavedStateGenericHandler
import com.pt.core.state.common.generic.StateTransitionGenericProvider
import com.pt.core.state.common.statebase.SavedStateHandler
import com.pt.core.state.common.statebase.StateTransitionProvider

/*
interface NavigationAdvancedHandler<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    StateTransitionGenericProvider<State, Event, SideEffect>,
    SavedStateGenericHandler<State, Event, SideEffect>
*/



interface NavigationAdvancedHandler : StateTransitionProvider, SavedStateHandler
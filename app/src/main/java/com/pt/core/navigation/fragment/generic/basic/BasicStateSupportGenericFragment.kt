package com.pt.core.navigation.fragment.generic.basic

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.core.state.manual.statebase.NavigationSimpleHandler

abstract class BasicStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationSimpleHandler<State, Event, SideEffect> {
    protected abstract val TAG: String
}

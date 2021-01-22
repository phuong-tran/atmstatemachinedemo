package com.pt.core.navigation.fragment.generic.basic

import android.os.Parcelable
import com.pt.core.navigation.fragment.FragmentBase
import com.pt.core.navigation.stateholder.generic.StateGenericHolder
import com.pt.core.state.manual.generic.NavigationSimpleGenericHandler

abstract class BasicStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    FragmentBase(),
    NavigationSimpleGenericHandler<State, Event, SideEffect>,
    StateGenericHolder<State, Event, SideEffect>

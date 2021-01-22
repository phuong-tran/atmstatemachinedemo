package com.pt.core.navigation.fragment.generic.advance

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.core.navigation.fragment.FragmentBase
import com.pt.core.navigation.stateholder.generic.StateGenericHolder
import com.pt.core.state.advance.generic.NavigationAdvancedGenericHandler
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler


abstract class AdvancedStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    FragmentBase(),
    NavigationAdvancedGenericHandler<State, Event, SideEffect>,
    StateGenericHolder<State, Event, SideEffect>
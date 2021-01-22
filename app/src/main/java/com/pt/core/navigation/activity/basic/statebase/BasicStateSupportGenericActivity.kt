package com.pt.core.navigation.activity.basic.statebase

import android.os.Parcelable
import com.pt.core.navigation.activity.BaseAppCompatActivity
import com.pt.core.state.manual.generic.NavigationSimpleGenericHandler

abstract class BasicStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    BaseAppCompatActivity(), NavigationSimpleGenericHandler<State, Event, SideEffect>
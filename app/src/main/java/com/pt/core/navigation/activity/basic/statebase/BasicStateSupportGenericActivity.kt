package com.pt.core.navigation.activity.basic.statebase

import android.os.Parcelable
import com.pt.core.navigation.activity.AppCompatActivityBase
import com.pt.core.state.manual.generic.NavigationSimpleGenericHandler

abstract class BasicStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivityBase(), NavigationSimpleGenericHandler<State, Event, SideEffect>
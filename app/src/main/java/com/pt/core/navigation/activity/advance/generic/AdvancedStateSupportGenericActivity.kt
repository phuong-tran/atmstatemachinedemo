package com.pt.core.navigation.activity.advance.generic

import android.os.Parcelable
import com.pt.core.navigation.activity.BaseAppCompatActivity
import com.pt.core.state.advance.generic.NavigationAdvancedGenericHandler


abstract class AdvancedStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    BaseAppCompatActivity(),
    NavigationAdvancedGenericHandler<State, Event, SideEffect>
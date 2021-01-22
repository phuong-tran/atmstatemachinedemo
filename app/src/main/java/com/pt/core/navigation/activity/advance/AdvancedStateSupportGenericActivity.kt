package com.pt.core.navigation.activity.advance

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.core.navigation.activity.BaseAppCompatActivity
import com.pt.core.state.advance.generic.NavigationAdvancedGenericHandler
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler


abstract class AdvancedStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    BaseAppCompatActivity(),
    NavigationAdvancedGenericHandler<State, Event, SideEffect>
package com.pt.state.navigation.activity.advance

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.state.navigation.state.advance.NavigationAdvancedHandler


abstract class AdvancedStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(),
    NavigationAdvancedHandler<State, Event, SideEffect>
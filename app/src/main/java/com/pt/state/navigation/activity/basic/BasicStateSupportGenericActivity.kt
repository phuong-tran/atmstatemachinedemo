package com.pt.state.navigation.activity.basic

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.state.navigation.state.manual.NavigationSimpleHandler

abstract class BasicStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(), NavigationSimpleHandler<State, Event, SideEffect> {
}
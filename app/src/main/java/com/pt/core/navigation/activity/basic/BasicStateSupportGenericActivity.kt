package com.pt.core.navigation.activity.basic

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.core.state.manual.statebase.NavigationSimpleHandler

abstract class BasicStateSupportGenericActivity<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(), NavigationSimpleHandler<State, Event, SideEffect> {
}
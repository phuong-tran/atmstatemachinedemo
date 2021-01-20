package com.pt.state.navigation.fragment.basic

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.state.navigation.state.manual.NavigationSimpleHandler

abstract class BasicStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationSimpleHandler<State, Event, SideEffect> {
    protected abstract val TAG: String
}

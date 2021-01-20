package com.pt.state.navigation.fragment.basic

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.state.navigation.ManualGenericSavedStateHandler
import com.pt.state.navigation.ManualSavedStateHandler
import com.pt.state.navigation.NavigationSimple


abstract class BasicStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationSimple<State, Event, SideEffect> {
    protected abstract val TAG : String
}

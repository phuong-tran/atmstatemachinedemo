package com.pt.state.navigation.fragment

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.state.navigation.NavigationSimple
import com.pt.state.navigation.StateTransitionProvider


abstract class SupportNavigationFragmentSimpleBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationSimple<State, Event, SideEffect> {
    protected abstract val TAG : String
}

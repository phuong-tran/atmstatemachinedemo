package com.pt.state.navigation.fragment.advance

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.state.navigation.state.advance.NavigationAdvancedHandler


abstract class AdvancedStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationAdvancedHandler<State, Event, SideEffect> {
        protected abstract val TAG : String
    }
package com.pt.core.navigation.fragment.generic.advance

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.core.state.advance.generic.NavigationAdvancedGenericHandler
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler


abstract class AdvancedStateSupportGenericFragment<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    NavigationAdvancedGenericHandler<State, Event, SideEffect> {
        protected abstract val TAG : String
    }
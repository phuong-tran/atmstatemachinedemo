package com.pt.core.navigation.viewmodel.generic

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.pt.core.state.advance.generic.NavigationAdvancedGenericHandler
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler

abstract class SupportStateGenericViewModel<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(
    navigation: NavigationAdvancedGenericHandler<State, Event, SideEffect>
) : ViewModel(), NavigationAdvancedGenericHandler<State, Event, SideEffect> by navigation {
    protected abstract val TAG: String
}
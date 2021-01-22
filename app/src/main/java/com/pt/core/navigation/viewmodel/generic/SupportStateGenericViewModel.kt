package com.pt.core.navigation.viewmodel.generic

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.pt.core.state.advance.NavigationAdvancedHandler

abstract class SupportStateGenericViewModel<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(
    navigation: NavigationAdvancedHandler<State, Event, SideEffect>
) : ViewModel(), NavigationAdvancedHandler<State, Event, SideEffect> by navigation {
    protected abstract val TAG: String
}
package com.pt.state.navigation.viewmodel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.pt.state.navigation.state.advance.NavigationAdvancedHandler

abstract class SupportStateGenericViewModel<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(
    navigation: NavigationAdvancedHandler<State, Event, SideEffect>
) : ViewModel(), NavigationAdvancedHandler<State, Event, SideEffect> by navigation {
    protected abstract val TAG: String
}
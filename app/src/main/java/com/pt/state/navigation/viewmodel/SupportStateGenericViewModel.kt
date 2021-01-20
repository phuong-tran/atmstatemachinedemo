package com.pt.state.navigation.viewmodel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.pt.state.navigation.Navigation

abstract class SupportStateGenericViewModel<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(
    navigation: Navigation<State, Event, SideEffect>
) : ViewModel(), Navigation<State, Event, SideEffect> by navigation {
    protected abstract val TAG: String
}
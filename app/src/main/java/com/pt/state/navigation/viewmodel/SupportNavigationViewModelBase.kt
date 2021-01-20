package com.pt.state.navigation.viewmodel

import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.pt.state.navigation.Navigation


abstract class SupportNavigationViewModelBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(
    navigation: Navigation<State, Event, SideEffect>
) : ViewModel(), Navigation<State, Event, SideEffect> by navigation {
   protected abstract val TAG: String
}


/*
abstract class SupportNavigationViewModelBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable>(navigation: Navigation<State, Event, SideEffect>) :
    ViewModel(),
    StateProvider<State, Event, SideEffect> by navigation,
    StateStorageManager<State, Event, SideEffect> by navigation,
    TransitionAction<State, Event, SideEffect> by navigation
*/

package com.pt.state.navigation.fragment

import android.os.Parcelable
import androidx.fragment.app.Fragment
import com.pt.state.navigation.Navigation


abstract class SupportNavigationFragmentBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    Navigation<State, Event, SideEffect> {
        protected abstract val TAG : String
    }


/*
abstract class SupportNavigationFragmentBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    Fragment(),
    StateStorageManager<State, Event, SideEffect>*/

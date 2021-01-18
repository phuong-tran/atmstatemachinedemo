package com.pt.state.navigation.activity

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.state.navigation.Navigation
import com.pt.state.navigation.StateStorageManager


abstract class SupportNavigationActivityBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(),
    Navigation<State, Event, SideEffect>


/*
abstract class SupportNavigationActivityBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(), StateStorageManager<State, Event, SideEffect>, */

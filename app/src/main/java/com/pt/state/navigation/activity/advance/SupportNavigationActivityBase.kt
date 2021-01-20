package com.pt.state.navigation.activity.advance

import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.pt.state.navigation.Navigation


abstract class SupportNavigationActivityBase<State : Parcelable, Event : Parcelable, SideEffect : Parcelable> :
    AppCompatActivity(),
    Navigation<State, Event, SideEffect>
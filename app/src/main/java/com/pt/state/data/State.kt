package com.pt.state.data

import android.os.Parcelable

sealed class State : Parcelable

// Hack
abstract class StateBase : State(), Parcelable
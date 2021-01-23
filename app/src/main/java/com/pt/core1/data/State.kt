package com.pt.core1.data

import android.os.Parcelable

sealed class State : Parcelable

// Hack
abstract class StateBase : State(), Parcelable
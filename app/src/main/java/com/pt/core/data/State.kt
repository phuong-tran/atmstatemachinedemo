package com.pt.core.data

import android.os.Parcelable

sealed class State : Parcelable

// Hack
abstract class StateBase : State(), Parcelable
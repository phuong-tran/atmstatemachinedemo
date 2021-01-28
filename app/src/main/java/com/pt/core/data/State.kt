package com.pt.core.data

import android.os.Parcelable

sealed class StateBase : Parcelable

// Hack
abstract class State : StateBase(), Parcelable
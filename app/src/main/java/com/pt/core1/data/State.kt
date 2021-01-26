package com.pt.core1.data

import android.os.Parcelable


sealed class StateBase : Parcelable

// Hack
abstract class State : StateBase(), Parcelable


/*
sealed class State : StateBase()

// Hack
abstract class StateBase : Parcelable*/

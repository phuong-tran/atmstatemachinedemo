package com.pt.core1.data

import android.os.Parcelable


sealed class EventBase : Parcelable

// Hack
abstract class Event : EventBase()
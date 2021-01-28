package com.pt.core.data

import android.os.Parcelable


sealed class EventBase : Parcelable

// Hack
abstract class Event : EventBase()
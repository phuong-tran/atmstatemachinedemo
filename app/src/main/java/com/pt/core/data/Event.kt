package com.pt.core.data

import android.os.Parcelable

sealed class Event : Parcelable

// Hack
abstract class EventBase : Event()
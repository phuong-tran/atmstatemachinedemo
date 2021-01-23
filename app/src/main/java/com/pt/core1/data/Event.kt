package com.pt.core1.data

import android.os.Parcelable

sealed class Event : Parcelable

// Hack
abstract class EventBase : Event()
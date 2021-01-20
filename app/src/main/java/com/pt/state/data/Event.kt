package com.pt.state.data

import android.os.Parcelable

sealed class Event : Parcelable {

}

// Hack
abstract class EventBase : Event() {

}
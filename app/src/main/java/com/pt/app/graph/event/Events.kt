package com.pt.app.graph.event

import com.pt.core.data.Event
import kotlinx.android.parcel.Parcelize

class Events {
    @Parcelize
    object InsertCard : Event() {
        override fun toString(): String {
            return "Event InsertCard"
        }
    }

    @Parcelize
    object EjectCart : Event() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }

    @Parcelize
    object VerifyCartSuccess : Event() {
        override fun toString(): String {
            return "Event VerifyCartSuccess"
        }
    }

    @Parcelize
    object VerifyCartFailure : Event() {
        override fun toString(): String {
            return "Event VerifyCartFailure"
        }
    }
}
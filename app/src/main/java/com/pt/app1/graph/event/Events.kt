package com.pt.app1.graph.event

import com.pt.core1.data.EventBase
import kotlinx.android.parcel.Parcelize

class Events {
    @Parcelize
    object InsertCard : EventBase() {
        override fun toString(): String {
            return "Event InsertCard"
        }
    }

    @Parcelize
    object EjectCart : EventBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }

    @Parcelize
    object VerifyCartSuccess : EventBase() {
        override fun toString(): String {
            return "Event VerifyCartSuccess"
        }
    }

    @Parcelize
    object VerifyCartFailure : EventBase() {
        override fun toString(): String {
            return "Event VerifyCartFailure"
        }
    }
}
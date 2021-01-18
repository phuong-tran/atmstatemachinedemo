package com.pt.app.state.manager.event

import com.pt.state.create
import com.pt.state.data.EventBase
import kotlinx.android.parcel.Parcelize

class Events {
    @Parcelize
    class InsertCard : EventBase() {
        override fun toString(): String {
            return "Event InsertCard"
        }

        companion object {
            private val insertCard: InsertCard by lazy {
                create { InsertCard() }
            }

            fun get(): InsertCard = insertCard
        }
    }

    @Parcelize
    class EjectCart : EventBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }

        companion object {
            private val ejectCart: EjectCart by lazy {
                create { EjectCart() }
            }

            fun get(): EjectCart = ejectCart
        }
    }

    @Parcelize
    class VerifyCartSuccess : EventBase() {
        override fun toString(): String {
            return "Event InsertCard"
        }
        companion object {
            private val verifyCartSuccess: VerifyCartSuccess by lazy {
                create { VerifyCartSuccess() }
            }

            fun get(): VerifyCartSuccess = verifyCartSuccess
        }
    }

    @Parcelize
    class VerifyCartFailure : EventBase() {
        override fun toString(): String {
            return "Event InsertCard"
        }
        companion object {
            private val verifyCartFailure: VerifyCartFailure by lazy {
                create { VerifyCartFailure() }
            }

            fun get(): VerifyCartFailure = verifyCartFailure
        }
    }
}
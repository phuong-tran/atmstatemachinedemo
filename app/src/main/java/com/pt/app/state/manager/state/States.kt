package com.pt.app.state.manager.state

import com.pt.core.create
import com.pt.core.data.StateBase
import kotlinx.android.parcel.Parcelize

class States {
    @Parcelize
    class IDLE : StateBase() {
        override fun toString(): String {
            return "STATE IDLE"
        }

        companion object {
            private val idle: IDLE by lazy {
                create { IDLE() }
            }

            fun get(): IDLE = idle
        }
    }


    @Parcelize
    class VerifyCart : StateBase() {
        override fun toString(): String {
            return "STATE VerifyCart"
        }

        companion object {
            private val verifyCart: VerifyCart by lazy {
                create { VerifyCart() }
            }

            fun get(): VerifyCart = verifyCart
        }
    }


    @Parcelize
    class InputPin : StateBase() {
        override fun toString(): String {
            return "STATE InputPin"
        }

        companion object {
            private val inputPin: InputPin by lazy {
                create { InputPin() }
            }

            fun get(): InputPin = inputPin
        }
    }
}

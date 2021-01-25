package com.pt.app.state.manager.state

import com.pt.core.data.StateBase
import kotlinx.android.parcel.Parcelize

class States {

    @Parcelize
    object IDLE : StateBase() {
        override fun toString(): String {
            return "STATE IDLE"
        }
    }


    @Parcelize
    object VerifyCart : StateBase() {
        override fun toString(): String {
            return "STATE VerifyCart"
        }
    }


    @Parcelize
    object InputPin : StateBase() {
        override fun toString(): String {
            return "STATE InputPin"
        }
    }
}

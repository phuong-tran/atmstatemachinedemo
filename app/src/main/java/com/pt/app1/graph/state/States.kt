package com.pt.app1.graph.state


import com.pt.core1.data.State
import com.pt.core1.data.StateBase
import kotlinx.android.parcel.Parcelize

class States {

    @Parcelize
    object IDLE : State() {
        override fun toString(): String {
            return "STATE IDLE"
        }
    }


    @Parcelize
    object VerifyCart : State() {
        override fun toString(): String {
            return "STATE VerifyCart"
        }
    }


    @Parcelize
    object InputPin : State() {
        override fun toString(): String {
            return "STATE InputPin"
        }
    }
}

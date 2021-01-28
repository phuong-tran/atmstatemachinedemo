package com.pt.app.graph.state


import com.pt.core.data.State
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

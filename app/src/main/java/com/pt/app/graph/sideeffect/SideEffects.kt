package com.pt.app.graph.sideeffect

import com.pt.core.data.SideEffect
import kotlinx.android.parcel.Parcelize

class SideEffects {
    @Parcelize
    object Introduce : SideEffect() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }

    @Parcelize
    object VerifyCardFailure : SideEffect() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }
}
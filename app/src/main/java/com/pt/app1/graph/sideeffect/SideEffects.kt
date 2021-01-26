package com.pt.app1.graph.sideeffect

import com.pt.core1.data.SideEffect
import com.pt.core1.data.SideEffectBase
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
package com.pt.app.state.manager.sideeffect

import com.pt.core.data.SideEffectBase
import kotlinx.android.parcel.Parcelize

class SideEffects {
    @Parcelize
    object Introduce : SideEffectBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }

    @Parcelize
    object VerifyCardFailure : SideEffectBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }
    }
}
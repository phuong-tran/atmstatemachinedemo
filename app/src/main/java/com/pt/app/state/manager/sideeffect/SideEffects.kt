package com.pt.app.state.manager.sideeffect

import com.pt.core.create
import com.pt.core.data.SideEffectBase
import kotlinx.android.parcel.Parcelize

class SideEffects {
    @Parcelize
    class Introduce : SideEffectBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }

        companion object {
            private val introduce: Introduce by lazy {
                create { Introduce() }
            }

            fun get(): Introduce = introduce
        }
    }

    @Parcelize
    class VerifyCardFailure : SideEffectBase() {
        override fun toString(): String {
            return "Event EjectCart"
        }

        companion object {
            private val verifyCardFailure: VerifyCardFailure by lazy {
                create { VerifyCardFailure() }
            }

            fun get(): VerifyCardFailure = verifyCardFailure
        }
    }
}
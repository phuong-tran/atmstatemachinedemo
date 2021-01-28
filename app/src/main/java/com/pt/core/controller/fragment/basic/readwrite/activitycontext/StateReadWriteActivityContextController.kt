package com.pt.core.controller.fragment.basic.readwrite.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.basic.readwrite.StateReadWriteExternalContextController

abstract class StateReadWriteActivityContextController : StateReadWriteExternalContextController() {
    override val TAG = "StateReadWriteActivityContextController"

    override fun providerContext(): Context? = activity
}
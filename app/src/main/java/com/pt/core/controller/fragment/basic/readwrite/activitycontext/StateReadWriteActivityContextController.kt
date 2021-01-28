package com.pt.core.controller.fragment.basic.readwrite.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.basic.readwrite.StateReadWriteExternalContextController

abstract class StateReadWriteActivityContextController : StateReadWriteExternalContextController() {
    override val TAG = "StateReadWriteActivityContextController"

    final override fun providerContext(): Context? = activity
}
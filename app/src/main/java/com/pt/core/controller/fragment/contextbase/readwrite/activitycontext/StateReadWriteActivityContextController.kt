package com.pt.core.controller.fragment.contextbase.readwrite.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.readwrite.StateReadWriteExternalContextController

abstract class StateReadWriteActivityContextController : StateReadWriteExternalContextController() {
    final override fun providerContext(): Context? = activity
}
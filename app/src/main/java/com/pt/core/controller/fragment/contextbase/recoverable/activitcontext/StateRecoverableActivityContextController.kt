package com.pt.core.controller.fragment.contextbase.recoverable.activitcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.recoverable.StateRecoverableExternalContextController

abstract class StateRecoverableActivityContextController :
    StateRecoverableExternalContextController() {
    override val TAG = "StateRecoverableActivityContextController"
    final override fun providerContext(): Context? = activity
}
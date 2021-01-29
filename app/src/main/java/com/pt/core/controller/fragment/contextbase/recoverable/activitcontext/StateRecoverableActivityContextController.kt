package com.pt.core.controller.fragment.contextbase.recoverable.activitcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.recoverable.StateRecoverableExternalContextController

abstract class StateRecoverableActivityContextController :
    StateRecoverableExternalContextController() {
    final override fun providerContext(): Context? = activity
}
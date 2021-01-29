package com.pt.core.controller.fragment.contextbase.changeable.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.changeable.StateChangeableExternalContextController

abstract class StateChangeableActivityContextController : StateChangeableExternalContextController() {
    final override fun providerContext(): Context? = activity
}
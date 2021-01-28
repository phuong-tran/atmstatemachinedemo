package com.pt.core.controller.fragment.basic.savestatehandle.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.basic.savestatehandle.StateSavedHandlerExternalContextController

abstract class StateSavedHandlerActivityContextController :
    StateSavedHandlerExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
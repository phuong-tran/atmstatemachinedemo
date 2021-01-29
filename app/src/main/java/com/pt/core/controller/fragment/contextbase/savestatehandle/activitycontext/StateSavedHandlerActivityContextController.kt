package com.pt.core.controller.fragment.contextbase.savestatehandle.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.savestatehandle.StateSavedHandlerExternalContextController

abstract class StateSavedHandlerActivityContextController :
    StateSavedHandlerExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
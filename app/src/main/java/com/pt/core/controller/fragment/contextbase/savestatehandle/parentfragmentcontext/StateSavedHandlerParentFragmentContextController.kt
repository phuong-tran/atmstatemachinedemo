package com.pt.core.controller.fragment.contextbase.savestatehandle.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.savestatehandle.StateSavedHandlerExternalContextController

abstract class StateSavedHandlerParentFragmentContextController :
    StateSavedHandlerExternalContextController() {
    final override fun providerContext(): Context? = activity
}
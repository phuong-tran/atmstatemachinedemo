package com.pt.core.controller.fragment.contextbase.savestatehandle.activitycontext

import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.contextbase.savestatehandle.StateSavedHandlerExternalContextController
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerActivityContextController(@LayoutRes layoutId: Int = 0) :
    StateSavedHandlerExternalContextController(layoutId) {

    override fun getStateProviderOnAttach(): StateContextSavedHandlerProvider? {
        return (activity as? StateContextSavedHandlerProvider)
    }
}
package com.pt.core.controller.fragment.contextbase.savestatehandle.parentfragmentcontext

import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.contextbase.savestatehandle.StateSavedHandlerExternalContextController
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerParentFragmentContextController(@LayoutRes layoutId: Int = 0) :
    StateSavedHandlerExternalContextController(layoutId) {

    override fun getStateProviderOnAttach(): StateContextSavedHandlerProvider? {
        return (parentFragment as? StateContextSavedHandlerProvider)
    }
}
package com.pt.core.controller.fragment.contextbase.statefull.parentfragmentcontext

import com.pt.core.controller.fragment.contextbase.savestatehandle.StateSavedHandlerExternalContextController
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerParentFragmentContextController :
    StateSavedHandlerExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextSavedHandlerProvider? {
       return parentFragment as? StateContextSavedHandlerProvider
    }
}
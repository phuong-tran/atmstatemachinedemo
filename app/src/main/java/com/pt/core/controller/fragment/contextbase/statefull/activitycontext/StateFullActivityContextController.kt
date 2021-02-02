package com.pt.core.controller.fragment.contextbase.statefull.activitycontext

import com.pt.core.controller.fragment.contextbase.statefull.StateFullExternalContextController
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateFullActivityContextController :
    StateFullExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextSavedHandlerProvider? {
        return activity as? StateContextSavedHandlerProvider
    }
}
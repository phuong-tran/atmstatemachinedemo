package com.pt.core.controller.fragment.contextbase.recoverable.activitcontext

import com.pt.core.controller.fragment.contextbase.recoverable.StateRecoverableExternalContextController
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StateRecoverableActivityContextController :
    StateRecoverableExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextBundleStorageProvider? {
       return activity as? StateContextBundleStorageProvider
    }
}
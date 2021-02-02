package com.pt.core.controller.fragment.contextbase.recoverable.parentfragmentcontext

import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.contextbase.recoverable.StateRecoverableExternalContextController
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StateRecoverableParentFragmentContextController(@LayoutRes layoutId: Int = 0) :
    StateRecoverableExternalContextController(layoutId) {

    override fun getStateProviderOnAttach(): StateContextBundleStorageProvider? {
        return parentFragment as? StateContextBundleStorageProvider
    }
}
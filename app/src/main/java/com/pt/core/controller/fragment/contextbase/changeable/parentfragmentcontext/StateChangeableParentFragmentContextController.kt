package com.pt.core.controller.fragment.contextbase.changeable.parentfragmentcontext

import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.contextbase.changeable.StateChangeableExternalContextController
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableParentFragmentContextController(@LayoutRes layoutId: Int = 0) :
    StateChangeableExternalContextController(layoutId) {

    override fun getStateProviderOnAttach(): StateContextChangeableProvider? {
        return parentFragment as? StateContextChangeableProvider
    }
}
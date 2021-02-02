package com.pt.core.controller.fragment.contextbase.changeable.activitycontext

import com.pt.core.controller.fragment.contextbase.changeable.StateChangeableExternalContextController
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableActivityContextController :
    StateChangeableExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextChangeableProvider? {
        return activity as? StateContextChangeableProvider
    }
}
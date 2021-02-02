package com.pt.core.controller.fragment.contextbase.readonly.activitycontext

import com.pt.core.controller.fragment.contextbase.readonly.StateReadOnlyExternalContextController
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider

abstract class StateReadOnlyFragmentActivityContextController :
    StateReadOnlyExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextReadOnlyProvider? {
       return activity as? StateContextReadOnlyProvider
    }
}
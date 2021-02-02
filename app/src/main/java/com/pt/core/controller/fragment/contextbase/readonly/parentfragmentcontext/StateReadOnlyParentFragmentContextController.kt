package com.pt.core.controller.fragment.contextbase.readonly.parentfragmentcontext

import com.pt.core.controller.fragment.contextbase.readonly.StateReadOnlyExternalContextController
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider

abstract class StateReadOnlyParentFragmentContextController :
    StateReadOnlyExternalContextController() {

    override fun getStateProviderOnAttach(): StateContextReadOnlyProvider? {
        return parentFragment as? StateContextReadOnlyProvider
    }

}
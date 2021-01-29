package com.pt.core.controller.fragment.contextbase.readonly.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyParentFragmentContextController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
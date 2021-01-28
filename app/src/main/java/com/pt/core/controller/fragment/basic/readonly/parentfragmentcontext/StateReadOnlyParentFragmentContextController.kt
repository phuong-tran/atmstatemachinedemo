package com.pt.core.controller.fragment.basic.readonly.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.basic.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyParentFragmentContextController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
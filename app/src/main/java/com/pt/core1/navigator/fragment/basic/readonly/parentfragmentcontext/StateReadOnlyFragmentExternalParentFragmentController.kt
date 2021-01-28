package com.pt.core1.navigator.fragment.basic.readonly.parentfragmentcontext

import android.content.Context
import com.pt.core1.navigator.fragment.basic.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyFragmentExternalParentFragmentController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
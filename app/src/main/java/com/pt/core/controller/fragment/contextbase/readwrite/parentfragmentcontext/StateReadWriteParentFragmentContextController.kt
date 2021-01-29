package com.pt.core.controller.fragment.contextbase.readwrite.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.readwrite.StateReadWriteExternalContextController

abstract class StateReadWriteParentFragmentContextController :
    StateReadWriteExternalContextController() {
    override val TAG = "StateReadWriteParentFragmentContextController"

    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
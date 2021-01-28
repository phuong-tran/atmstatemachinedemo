package com.pt.core.controller.fragment.basic.readwrite.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.basic.readwrite.StateReadWriteExternalContextController

abstract class StateReadWriteParentFragmentContextController :
    StateReadWriteExternalContextController() {
    override val TAG = "StateReadWriteParentFragmentContextController"

    override fun providerContext(): Context? = parentFragment?.requireContext()
}
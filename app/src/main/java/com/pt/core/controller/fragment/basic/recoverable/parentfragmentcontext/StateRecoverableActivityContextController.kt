package com.pt.core.controller.fragment.basic.recoverable.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.basic.full.StateFullExternalContextController
import com.pt.core.controller.fragment.basic.recoverable.StateRecoverableExternalContextController

abstract class StateRecoverableActivityContextController :
    StateFullExternalContextController() {
    override val TAG = "StateRecoverableParentFragmentContextController"
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
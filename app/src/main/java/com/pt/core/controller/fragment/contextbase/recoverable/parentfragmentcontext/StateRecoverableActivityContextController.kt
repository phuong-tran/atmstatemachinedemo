package com.pt.core.controller.fragment.contextbase.recoverable.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.statefull.StateFullExternalContextController

abstract class StateRecoverableActivityContextController :
    StateFullExternalContextController() {
    override val TAG = "StateRecoverableParentFragmentContextController"
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
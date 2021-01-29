package com.pt.core.controller.fragment.contextbase.statefull.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.statefull.StateFullExternalContextController

abstract class StateFullActivityContextController :
    StateFullExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
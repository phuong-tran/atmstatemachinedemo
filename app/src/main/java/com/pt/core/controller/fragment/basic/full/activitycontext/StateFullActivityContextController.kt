package com.pt.core.controller.fragment.basic.full.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.basic.full.StateFullExternalContextController

abstract class StateFullActivityContextController :
    StateFullExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
package com.pt.core.controller.fragment.basic.readonly.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.basic.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyFragmentActivityContextController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = activity
}
package com.pt.core.controller.fragment.contextbase.readonly.activitycontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyFragmentActivityContextController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = activity
}
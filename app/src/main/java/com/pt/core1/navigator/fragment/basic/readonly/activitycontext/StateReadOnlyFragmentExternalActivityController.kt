package com.pt.core1.navigator.fragment.basic.readonly.activitycontext

import android.content.Context
import com.pt.core1.navigator.fragment.basic.readonly.StateReadOnlyExternalContextController

abstract class StateReadOnlyFragmentExternalActivityController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = activity
}
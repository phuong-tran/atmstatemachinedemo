package com.pt.core1.navigator.fragment.basic.readonly.activitycontext

import android.content.Context
import com.pt.core1.navigator.fragment.BaseFragment
import com.pt.core1.navigator.fragment.basic.readonly.StateReadOnlyExternalContextController
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StateReadOnlyFragmentExternalActivityController :
    StateReadOnlyExternalContextController() {
    final override fun providerContext(): Context? = activity
}
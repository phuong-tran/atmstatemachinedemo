package com.pt.core.controller.fragment.basic.full.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.fragment.basic.savestatehandle.StateSavedHandlerExternalContextController
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerParentFragmentContextController :
    StateSavedHandlerExternalContextController() {
    final override fun providerContext(): Context? = activity
}
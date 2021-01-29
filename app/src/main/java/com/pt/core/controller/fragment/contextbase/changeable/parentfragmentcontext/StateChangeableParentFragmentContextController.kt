package com.pt.core.controller.fragment.contextbase.changeable.parentfragmentcontext

import android.content.Context
import com.pt.core.controller.fragment.contextbase.changeable.StateChangeableExternalContextController

abstract class StateChangeableParentFragmentContextController :
    StateChangeableExternalContextController() {
    final override fun providerContext(): Context? = parentFragment?.requireContext()
}
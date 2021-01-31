package com.pt.core.controller.fragment.contextbase.changeable.parentfragmentcontext

import android.content.Context
import android.util.Log
import androidx.annotation.LayoutRes
import com.pt.backstackcontroller.navigation.StackFragment
import com.pt.core.controller.fragment.contextbase.changeable.StateChangeableExternalContextController

abstract class StateChangeableParentFragmentContextController(@LayoutRes layoutId: Int = 0) :
    StateChangeableExternalContextController(layoutId) {
    final override fun providerContext(): Context? {
        return parentFragment?.context
    }
}
package com.pt.core.controller.fragment.contextbase.savestatehandle

import android.content.Context
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerExternalContextController(@LayoutRes layoutId: Int = 0) :
    BaseFragment(layoutId) {
    protected var stateContext: StateContextSavedHandlerProvider? = null

    protected abstract fun getStateProviderOnAttach(): StateContextSavedHandlerProvider?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getStateProviderOnAttach()?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextSavedHandlerProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}

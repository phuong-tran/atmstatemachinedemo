package com.pt.core.controller.fragment.contextbase.recoverable

import android.content.Context
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StateRecoverableExternalContextController(@LayoutRes layoutId: Int = 0) :
    BaseFragment(layoutId) {
    protected var stateContext: StateContextBundleStorageProvider? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getStateProviderOnAttach()?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextBundleStorageProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }

    protected abstract fun getStateProviderOnAttach(): StateContextBundleStorageProvider?
}
package com.pt.core.controller.fragment.contextbase.recoverable

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StateRecoverableExternalContextController : BaseFragment() {
    protected var stateContext: StateContextBundleStorageProvider? = null
        private set

    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextBundleStorageProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextBundleStorageProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
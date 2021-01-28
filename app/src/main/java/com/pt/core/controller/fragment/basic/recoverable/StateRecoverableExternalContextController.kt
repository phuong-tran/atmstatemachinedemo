package com.pt.core.controller.fragment.basic.recoverable

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextBundleStorageProvider

abstract class StateRecoverableExternalContextController : BaseFragment() {
    override val TAG: String = "StateRecoverableExternalContextController"
    protected var stateContext: StateContextBundleStorageProvider? = null
        private set

    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextBundleStorageProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextReadOnlyProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
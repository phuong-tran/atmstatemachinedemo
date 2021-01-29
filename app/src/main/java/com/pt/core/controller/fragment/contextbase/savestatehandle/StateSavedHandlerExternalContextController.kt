package com.pt.core.controller.fragment.contextbase.savestatehandle

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerExternalContextController : BaseFragment() {
    protected var stateContext: StateContextSavedHandlerProvider? = null
        private set

    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextSavedHandlerProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextSavedHandlerProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}

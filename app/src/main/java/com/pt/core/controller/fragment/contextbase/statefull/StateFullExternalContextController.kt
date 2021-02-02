package com.pt.core.controller.fragment.contextbase.statefull

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateFullExternalContextController : BaseFragment() {
    protected var stateContext: StateContextSavedHandlerProvider? = null
        private set


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

    protected abstract fun getStateProviderOnAttach(): StateContextSavedHandlerProvider?
}

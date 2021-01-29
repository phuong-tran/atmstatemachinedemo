package com.pt.core.controller.fragment.contextbase.readonly

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider

abstract class StateReadOnlyExternalContextController : BaseFragment() {
    protected var stateContext: StateContextReadOnlyStateMachineProvider? = null
        private set

    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextReadOnlyStateMachineProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextReadOnlyStateMachineProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
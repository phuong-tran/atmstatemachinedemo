package com.pt.core1.navigator.fragment.basic.readonly

import android.content.Context
import com.pt.core1.navigator.fragment.BaseFragment
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StateReadOnlyExternalContextController : BaseFragment() {
    protected var stateContext: StateContextReadOnlyProvider? = null
        private set
    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextReadOnlyProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextReadOnlyProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
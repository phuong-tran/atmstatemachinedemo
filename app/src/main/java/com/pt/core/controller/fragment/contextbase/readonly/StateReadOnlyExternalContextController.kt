package com.pt.core.controller.fragment.contextbase.readonly

import android.content.Context
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider

abstract class StateReadOnlyExternalContextController(@LayoutRes layoutId: Int = 0) :
    BaseFragment(layoutId) {
    protected var stateContext: StateContextReadOnlyProvider? = null

    protected abstract fun getStateProviderOnAttach(): StateContextReadOnlyProvider?

    override fun onAttach(context: Context) {
        super.onAttach(context)

        getStateProviderOnAttach()?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextReadOnlyProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
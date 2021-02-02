package com.pt.core.controller.fragment.contextbase.changeable

import android.content.Context
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableExternalContextController(@LayoutRes layoutId: Int = 0) :
    BaseFragment(layoutId) {
    protected var stateContext: StateContextChangeableProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        getStateProviderOnAttach()?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextChangeableProvider")

    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }

    protected abstract fun getStateProviderOnAttach(): StateContextChangeableProvider?
}
package com.pt.core.controller.fragment.contextbase.changeable

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.pt.backstackcontroller.navigation.StackFragment
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableExternalContextController(@LayoutRes layoutId: Int = 0) : BaseFragment(layoutId) {
    protected var stateContext: StateContextChangeableProvider? = null
        private set

    abstract fun providerContext(): Context?

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (providerContext() as? StateContextChangeableProvider)?.let {
            stateContext = it
        }
            ?: throw IllegalArgumentException("Context must be implemented StateContextChangeableProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }

}
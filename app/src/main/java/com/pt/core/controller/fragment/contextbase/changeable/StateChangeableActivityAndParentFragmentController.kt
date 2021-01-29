package com.pt.core.controller.fragment.contextbase.changeable

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableActivityAndParentFragmentController : BaseFragment() {

    protected var stateContextActivity: StateContextChangeableProvider? = null
        private set

    protected var stateContextParentFragment: StateContextChangeableProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextChangeableProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextChangeableProvider")

        (parentFragment as? StateContextChangeableProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateContextChangeableProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}


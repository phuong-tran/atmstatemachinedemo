package com.pt.core.controller.fragment.basic.readwrite

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextReadWriteProvider

abstract class StateReadWriteActivityAndParentFragmentController : BaseFragment() {

    protected var stateContextActivity: StateContextReadWriteProvider? = null
        private set

    protected var stateContextParentFragment: StateContextReadWriteProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextReadWriteProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadWriteProvider")

        (parentFragment as? StateContextReadWriteProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateContextReadWriteProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}


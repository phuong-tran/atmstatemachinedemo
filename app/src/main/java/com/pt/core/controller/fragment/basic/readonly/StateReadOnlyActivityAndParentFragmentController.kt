package com.pt.core.controller.fragment.basic.readonly

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StateReadOnlyActivityAndParentFragmentController : BaseFragment() {
    protected var stateContextActivity: StateContextReadOnlyProvider? = null
        private set

    protected var stateContextParentFragment: StateContextReadOnlyProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextReadOnlyProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadOnlyProvider")

        (parentFragment as? StateContextReadOnlyProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateContextReadOnlyProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}
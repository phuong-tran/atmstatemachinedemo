package com.pt.core.controller.fragment.contextbase.readonly

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider

abstract class StateReadOnlyActivityAndParentFragmentController : BaseFragment() {
    protected var stateContextActivity: StateContextReadOnlyStateMachineProvider? = null
        private set

    protected var stateContextParentFragment: StateContextReadOnlyStateMachineProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextReadOnlyStateMachineProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadOnlyStateMachineProvider")

        (parentFragment as? StateContextReadOnlyStateMachineProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateContextReadOnlyStateMachineProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}
package com.pt.core.controller.fragment.basic.full

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateFullContextProvider

class StateFullActivityAndParentFragmentContextController : BaseFragment() {

    override val TAG = "StateRecoverableActivityAndParentFragmentContextController"
    protected var stateContextActivity: StateFullContextProvider? = null
        private set

    protected var stateContextParentFragment: StateFullContextProvider? = null
        private set


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateFullContextProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadWriteProvider")

        (parentFragment as? StateFullContextProvider)?.let {
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
package com.pt.core.controller.fragment.contextbase.statefull

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateFullContextProvider

abstract class StateFullActivityAndParentFragmentContextController : BaseFragment() {
    protected var stateContextActivity: StateFullContextProvider? = null
        private set

    protected var stateContextParentFragment: StateFullContextProvider? = null
        private set


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateFullContextProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateFullContextProvider")

        (parentFragment as? StateFullContextProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateFullContextProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}
package com.pt.core.controller.fragment.basic.savestatehandle

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

class StateSavedHandlerActivityAndParentFragmentContextController : BaseFragment() {

    override val TAG = "StateRecoverableActivityAndParentFragmentContextController"
    protected var stateContextActivity: StateContextSavedHandlerProvider? = null
        private set

    protected var stateContextParentFragment: StateContextSavedHandlerProvider? = null
        private set


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextSavedHandlerProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadWriteProvider")

        (parentFragment as? StateContextSavedHandlerProvider)?.let {
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
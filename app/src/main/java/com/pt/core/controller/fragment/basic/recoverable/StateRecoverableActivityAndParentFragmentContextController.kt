package com.pt.core.controller.fragment.basic.recoverable

import android.content.Context
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextBundleStorageProvider

abstract class StateRecoverableActivityAndParentFragmentContextController : BaseFragment() {
    override val TAG = "StateRecoverableActivityAndParentFragmentContextController"
    protected var stateContextActivity: StateContextBundleStorageProvider? = null
        private set

    protected var stateContextParentFragment: StateContextBundleStorageProvider? = null
        private set


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextBundleStorageProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextReadWriteProvider")

        (parentFragment as? StateContextBundleStorageProvider)?.let {
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
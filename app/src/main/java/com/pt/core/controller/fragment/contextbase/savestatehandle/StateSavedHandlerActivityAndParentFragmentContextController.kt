package com.pt.core.controller.fragment.contextbase.savestatehandle

import android.content.Context
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerActivityAndParentFragmentContextController(@LayoutRes layoutId: Int = 0) :
    BaseFragment(layoutId) {
    protected var stateContextActivity: StateContextSavedHandlerProvider? = null
        private set

    protected var stateContextParentFragment: StateContextSavedHandlerProvider? = null
        private set


    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as? StateContextSavedHandlerProvider)?.let {
            stateContextActivity = it
        }
            ?: throw IllegalArgumentException("Activity must be implemented StateContextSavedHandlerProvider")

        (parentFragment as? StateContextSavedHandlerProvider)?.let {
            stateContextParentFragment = it
        }
            ?: throw IllegalArgumentException("ParentFragment must be implemented StateContextSavedHandlerProvider")


    }

    override fun onDetach() {
        super.onDetach()
        stateContextActivity = null
        stateContextParentFragment = null
    }
}
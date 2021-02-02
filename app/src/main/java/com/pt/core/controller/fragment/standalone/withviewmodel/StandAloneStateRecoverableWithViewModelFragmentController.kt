package com.pt.core.controller.fragment.standalone.withviewmodel

import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.controller.viewmodel.recoverable.StateRecoverableViewModelController
import com.pt.core.data.TransitionData

abstract class StandAloneStateRecoverableWithViewModelFragmentController(@LayoutRes layoutId: Int = 0) :
    StandAloneStateRecoverableFragmentController(layoutId) {
    abstract val viewModel: StateRecoverableViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
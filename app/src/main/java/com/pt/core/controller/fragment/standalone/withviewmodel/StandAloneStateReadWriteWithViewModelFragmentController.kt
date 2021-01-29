package com.pt.core.controller.fragment.standalone.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StandAloneStateReadWriteWithViewModelFragmentController :
    StandAloneStateRecoverableFragmentController() {
    override val TAG = "StandAloneStateRecoverableWithViewModelFragmentController"
    abstract val viewModel: StateReadWriteViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
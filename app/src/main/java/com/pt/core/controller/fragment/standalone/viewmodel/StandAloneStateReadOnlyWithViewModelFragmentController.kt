package com.pt.core.controller.fragment.standalone.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.basic.StandAloneStateReadOnlyFragmentController
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StandAloneStateReadOnlyWithViewModelFragmentController :
    StandAloneStateReadOnlyFragmentController() {
    override val TAG = "StandAloneStateReadOnlyWithViewModelFragmentController"
    abstract val viewModel: StateReadWriteViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
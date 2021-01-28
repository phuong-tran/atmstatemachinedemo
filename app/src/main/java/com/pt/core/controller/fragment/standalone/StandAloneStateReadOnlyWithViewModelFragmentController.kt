package com.pt.core.controller.fragment.standalone

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.StateBasicViewModel

abstract class StandAloneStateReadOnlyWithViewModelFragmentController :
    StandAloneStateReadOnlyFragmentController() {
    override val TAG = "StandAloneStateReadOnlyWithViewModelFragmentController"
    abstract val viewModel: StateBasicViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
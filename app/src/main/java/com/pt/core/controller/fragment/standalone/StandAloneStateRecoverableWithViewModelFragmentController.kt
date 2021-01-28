package com.pt.core.controller.fragment.standalone

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.StateSavedHandlerViewModel

abstract class StandAloneStateRecoverableWithViewModelFragmentController :
    StandAloneStateRecoverableFragmentController() {
    override val TAG = "StandAloneStateRecoverableWithViewModelFragmentController"
    abstract val viewModel: StateSavedHandlerViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
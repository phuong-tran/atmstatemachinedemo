package com.pt.core.controller.fragment.standalone.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.controller.viewmodel.recoverable.StateRecoverableViewModelController
import com.pt.core.data.TransitionData

abstract class StandAloneStateRecoverableWithViewModelFragmentController :
    StandAloneStateRecoverableFragmentController() {
    abstract val viewModel: StateRecoverableViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
package com.pt.core.controller.fragment.standalone.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.changeable.StateChangeableViewModelController

abstract class StandAloneStateChangeableWithViewModelFragmentController :
    StandAloneStateRecoverableFragmentController() {
    abstract val viewModel: StateChangeableViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
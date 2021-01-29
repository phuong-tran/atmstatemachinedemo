package com.pt.core.controller.fragment.standalone.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.basic.StandAloneStateFullFragmentController
import com.pt.core.controller.viewmodel.statefull.StateFullContextViewModelController
import com.pt.core.data.TransitionData

abstract class StandAloneStateFullWithViewModelFragmentController :
    StandAloneStateFullFragmentController() {
    abstract val viewModel: StateFullContextViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StandAloneStateFullActivityController
import com.pt.core.controller.viewmodel.full.StateFullContextViewModelController

abstract class StateFullActivityWithViewModelController : StandAloneStateFullActivityController() {
    override val TAG = "StateDefaultActivityWithViewModelController"
    protected abstract val viewModel: StateFullContextViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
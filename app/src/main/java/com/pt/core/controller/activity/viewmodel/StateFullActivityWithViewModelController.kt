package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateFullActivityController
import com.pt.core.controller.viewmodel.full.StateFullContextViewModelController

abstract class StateFullActivityWithViewModelController : StateFullActivityController() {
    override val TAG = "StateDefaultActivityWithViewModelController"
    protected abstract val viewModel: StateFullContextViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.activity.basic.StateReadWriteActivityController
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController
import com.pt.core.data.TransitionData

abstract class StateReadWriteActivityWithViewModelController : StateReadWriteActivityController() {
    protected abstract val viewModel: StateReadWriteViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
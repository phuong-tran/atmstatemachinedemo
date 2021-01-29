package com.pt.core.controller.activity.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StandAloneStateReadWriteActivityController
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StateRecoverableActivityWithViewModelController :
    StandAloneStateReadWriteActivityController() {
    protected abstract val viewModel: StateReadWriteViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
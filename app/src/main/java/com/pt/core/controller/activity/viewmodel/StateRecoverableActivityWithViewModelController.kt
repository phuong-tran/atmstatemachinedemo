package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StateReadWriteActivityController
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StateRecoverableActivityWithViewModelController :
    StateReadWriteActivityController() {
    protected abstract val viewModel: StateReadWriteViewModelController
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
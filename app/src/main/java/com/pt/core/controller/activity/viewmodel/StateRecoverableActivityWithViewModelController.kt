package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateRecoverableActivityController
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StateRecoverableActivityWithViewModelController :
    StateRecoverableActivityController() {
    protected abstract val viewModel: StateReadWriteViewModelController
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
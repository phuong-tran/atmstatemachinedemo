package com.pt.core.controller.activity.advance

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateRecoverableActivityController
import com.pt.core.controller.viewmodel.StateBasicViewModel

abstract class StateRecoverableActivityWithViewModelController :
    StateRecoverableActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
package com.pt.core1.navigator.activity.advance

import androidx.annotation.CallSuper
import com.pt.core1.data.TransitionData
import com.pt.core1.navigator.activity.basic.StateRecoverableActivityController
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StateRecoverableActivityWithViewModelController :
    StateRecoverableActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
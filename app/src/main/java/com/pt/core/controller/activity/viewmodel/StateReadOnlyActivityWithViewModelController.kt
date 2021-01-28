package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateReadOnlyActivityController
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController

abstract class StateReadOnlyActivityWithViewModelController : StateReadOnlyActivityController() {
    protected abstract val viewModel: StateReadOnlyViewModelController
    override val TAG = "StateReadOnlyActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
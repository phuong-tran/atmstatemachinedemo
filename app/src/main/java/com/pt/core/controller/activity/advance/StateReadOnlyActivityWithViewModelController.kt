package com.pt.core.controller.activity.advance

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateReadOnlyActivityController
import com.pt.core.controller.viewmodel.StateBasicViewModel

abstract class StateReadOnlyActivityWithViewModelController : StateReadOnlyActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateReadOnlyActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
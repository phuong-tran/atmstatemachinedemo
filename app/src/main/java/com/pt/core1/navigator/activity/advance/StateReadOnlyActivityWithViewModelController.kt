package com.pt.core1.navigator.activity.advance

import androidx.annotation.CallSuper
import com.pt.core1.data.TransitionData
import com.pt.core1.navigator.activity.basic.StateReadOnlyActivityController
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StateReadOnlyActivityWithViewModelController : StateReadOnlyActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateReadOnlyActivityWithViewModelController"

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
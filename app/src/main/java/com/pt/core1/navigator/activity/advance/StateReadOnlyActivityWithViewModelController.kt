package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.StateReadOnlyActivityController
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StateReadOnlyActivityWithViewModelController : StateReadOnlyActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateReadOnlyActivityWithViewModelController"
}
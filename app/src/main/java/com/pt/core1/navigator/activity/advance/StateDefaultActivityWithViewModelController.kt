package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.StateDefaultActivityController
import com.pt.core1.navigator.viewmodel.StateSavedHandlerViewModel

abstract class StateDefaultActivityWithViewModelController : StateDefaultActivityController() {
    override val TAG = "StateDefaultActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModel
}
package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.FullStateActivityController
import com.pt.core1.navigator.viewmodel.StateSavedHandlerViewModel

abstract class FullStateActivityWithViewModelController : FullStateActivityController() {
    override val TAG = "StateDefaultActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModel
}
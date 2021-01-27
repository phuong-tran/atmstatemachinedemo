package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.StateSupportSavedHandlerStorageActivityController
import com.pt.core1.navigator.viewmodel.StateSavedHandlerViewModel

abstract class StateSupportSavedHandlerStorageActivityWithViewModelController :
    StateSupportSavedHandlerStorageActivityController() {
    override val TAG = "StateSupportSavedHandlerStorageActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModel
}
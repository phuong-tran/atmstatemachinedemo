package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.StateSupportBundleStorageActivityController
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StateSupportBundleStorageActivityWithViewModelController :
    StateSupportBundleStorageActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"
}
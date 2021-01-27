package com.pt.core1.navigator.activity.advance

import com.pt.core1.navigator.activity.basic.StateRecoverableActivityController
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StateSupportBundleStorageActivityWithViewModelController :
    StateRecoverableActivityController() {
    protected abstract val viewModel: StateBasicViewModel
    override val TAG = "StateSupportBundleStorageActivityWithViewModelController"
}
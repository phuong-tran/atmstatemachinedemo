package com.pt.core1.navigator.activity.advance

import androidx.annotation.CallSuper
import com.pt.core1.data.TransitionData
import com.pt.core1.navigator.activity.basic.StateWithSavedHandlerStorageActivityController
import com.pt.core1.navigator.viewmodel.StateSavedHandlerViewModel

abstract class StateWithSavedHandlerStorageActivityWithViewModelController :
    StateWithSavedHandlerStorageActivityController() {
    override val TAG = "StateSupportSavedHandlerStorageActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
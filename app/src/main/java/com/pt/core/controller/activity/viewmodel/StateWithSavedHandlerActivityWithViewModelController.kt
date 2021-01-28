package com.pt.core.controller.activity.viewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.StateWithSavedHandlerActivityController
import com.pt.core.controller.viewmodel.savedstatehandle.StateSavedHandlerViewModelController

abstract class StateWithSavedHandlerActivityWithViewModelController :
    StateWithSavedHandlerActivityController() {
    override val TAG = "StateSupportSavedHandlerStorageActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
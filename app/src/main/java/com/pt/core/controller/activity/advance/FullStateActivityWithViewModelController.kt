package com.pt.core.controller.activity.advance

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.basic.FullStateActivityController
import com.pt.core.controller.viewmodel.StateSavedHandlerViewModel

abstract class FullStateActivityWithViewModelController : FullStateActivityController() {
    override val TAG = "StateDefaultActivityWithViewModelController"
    protected abstract val viewModel: StateSavedHandlerViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
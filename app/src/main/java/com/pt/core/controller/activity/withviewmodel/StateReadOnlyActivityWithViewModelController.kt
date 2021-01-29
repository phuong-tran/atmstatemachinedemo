package com.pt.core.controller.activity.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StandAloneStateReadOnlyActivityController
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController

abstract class StateReadOnlyActivityWithViewModelController : StandAloneStateReadOnlyActivityController() {
    protected abstract val viewModel: StateReadOnlyViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
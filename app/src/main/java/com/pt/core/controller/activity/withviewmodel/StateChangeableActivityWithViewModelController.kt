package com.pt.core.controller.activity.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.activity.standalone.StandAloneStateChangeableActivityController
import com.pt.core.controller.viewmodel.changeable.StateChangeableViewModelController
import com.pt.core.data.TransitionData

abstract class StateChangeableActivityWithViewModelController : StandAloneStateChangeableActivityController() {
    protected abstract val viewModel: StateChangeableViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
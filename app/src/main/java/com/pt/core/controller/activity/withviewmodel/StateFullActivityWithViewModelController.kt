package com.pt.core.controller.activity.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.data.TransitionData
import com.pt.core.controller.activity.standalone.StandAloneStateFullActivityController
import com.pt.core.controller.viewmodel.statefull.StateFullContextViewModelController

abstract class StateFullActivityWithViewModelController : StandAloneStateFullActivityController() {
    protected abstract val viewModel: StateFullContextViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
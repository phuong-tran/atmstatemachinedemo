package com.pt.core.controller.fragment.standalone.withviewmodel

import androidx.annotation.CallSuper
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateReadOnlyFragmentController
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.changeable.StateChangeableViewModelController

abstract class StandAloneStateReadOnlyWithViewModelFragmentController :
    StandAloneStateReadOnlyFragmentController() {
    abstract val viewModel: StateChangeableViewModelController

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
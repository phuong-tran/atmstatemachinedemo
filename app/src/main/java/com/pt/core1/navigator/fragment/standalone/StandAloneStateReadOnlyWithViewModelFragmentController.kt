package com.pt.core1.navigator.fragment.standalone

import androidx.annotation.CallSuper
import com.pt.core1.data.TransitionData
import com.pt.core1.navigator.viewmodel.StateBasicViewModel

abstract class StandAloneStateReadOnlyWithViewModelFragmentController :
    StandAloneStateReadOnlyFragmentController() {
    override val TAG = "StandAloneStateReadOnlyWithViewModelFragmentController"
    abstract val viewModel: StateBasicViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
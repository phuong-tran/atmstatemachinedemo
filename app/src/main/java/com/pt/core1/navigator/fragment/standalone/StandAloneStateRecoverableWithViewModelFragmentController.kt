package com.pt.core1.navigator.fragment.standalone

import androidx.annotation.CallSuper
import com.pt.core1.data.TransitionData
import com.pt.core1.navigator.viewmodel.StateSavedHandlerViewModel

abstract class StandAloneStateRecoverableWithViewModelFragmentController :
    StandAloneStateRecoverableFragmentController() {
    override val TAG = "StandAloneStateRecoverableWithViewModelFragmentController"
    abstract val viewModel: StateSavedHandlerViewModel

    @CallSuper
    override fun onTransaction(transitionData: TransitionData) {
        viewModel.onTransaction(transitionData)
    }
}
package com.pt.core.controller.fragment.shareviewmodel.readonly

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController
import com.pt.core.controller.viewmodel.factory.createStateBasicFactory

abstract class StateSharedReadOnlyViewModelFragment : BaseFragment() {
    override val TAG = "StateSharedReadOnlyViewModelFragment"
    abstract fun provideSharedViewModel(): StateReadOnlyViewModelController

    protected val viewModel: StateReadOnlyViewModelController by activityViewModels {
        createStateBasicFactory {
            provideSharedViewModel()
        }
    }
}
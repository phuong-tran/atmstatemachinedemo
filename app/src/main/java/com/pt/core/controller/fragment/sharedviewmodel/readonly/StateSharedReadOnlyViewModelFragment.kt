package com.pt.core.controller.fragment.sharedviewmodel.readonly

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController

abstract class StateSharedReadOnlyViewModelFragment : BaseFragment() {
    override val TAG = "StateSharedReadOnlyViewModelFragment"
    abstract fun provideSharedViewModel(): StateReadOnlyViewModelController

    protected val viewModel: StateReadOnlyViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
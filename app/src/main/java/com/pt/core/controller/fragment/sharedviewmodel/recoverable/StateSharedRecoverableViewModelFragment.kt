package com.pt.core.controller.fragment.sharedviewmodel.recoverable

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.recoverable.StateRecoverableViewModelController

abstract class StateSharedRecoverableViewModelFragment : BaseFragment() {
    abstract fun provideSharedViewModel(): StateRecoverableViewModelController
    protected val viewModel: StateRecoverableViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
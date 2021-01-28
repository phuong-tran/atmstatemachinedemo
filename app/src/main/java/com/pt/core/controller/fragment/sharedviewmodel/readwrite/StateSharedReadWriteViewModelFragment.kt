package com.pt.core.controller.fragment.sharedviewmodel.readwrite

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.readwrite.StateReadWriteViewModelController

abstract class StateSharedReadWriteViewModelFragment : BaseFragment() {
    abstract fun provideSharedViewModel(): StateReadWriteViewModelController

    protected val viewModel: StateReadWriteViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
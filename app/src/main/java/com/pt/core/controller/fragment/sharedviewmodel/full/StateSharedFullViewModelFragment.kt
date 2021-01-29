package com.pt.core.controller.fragment.sharedviewmodel.full

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.full.StateFullContextViewModelController

abstract class StateSharedFullViewModelFragment : BaseFragment() {
    abstract fun provideSharedViewModel(): StateFullContextViewModelController

    protected val viewModel: StateFullContextViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
package com.pt.core.controller.fragment.sharedviewmodel.changeable

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.changeable.StateChangeableViewModelController

abstract class StateSharedChangeableViewModelFragment : BaseFragment() {
    abstract fun provideSharedViewModel(): StateChangeableViewModelController

    protected val viewModel: StateChangeableViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
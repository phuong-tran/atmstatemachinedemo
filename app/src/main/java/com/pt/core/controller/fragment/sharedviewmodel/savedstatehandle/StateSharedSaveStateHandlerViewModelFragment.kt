package com.pt.core.controller.fragment.sharedviewmodel.savedstatehandle

import androidx.fragment.app.activityViewModels
import com.pt.core.controller.fragment.BaseFragment
import com.pt.core.controller.viewmodel.factory.createViewModelFactory
import com.pt.core.controller.viewmodel.recoverable.StateRecoverableViewModelController
import com.pt.core.controller.viewmodel.savedstatehandle.StateSavedHandlerViewModelController

abstract class StateSharedSaveStateHandlerViewModelFragment : BaseFragment() {
    abstract fun provideSharedViewModel(): StateSavedHandlerViewModelController

    protected val viewModel: StateSavedHandlerViewModelController by activityViewModels {
        createViewModelFactory {
            provideSharedViewModel()
        }
    }
}
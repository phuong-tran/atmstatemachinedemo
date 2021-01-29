package com.pt.core.controller.fragment.standalone.withviewmodel

import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateSavedHandlerFragmentController
import com.pt.core.controller.viewmodel.savedstatehandle.StateSavedHandlerViewModelController

abstract class StandAloneStateSavedHandlerWithViewModelFragmentController :
    StandAloneStateSavedHandlerFragmentController() {
    abstract val viewModel: StateSavedHandlerViewModelController
}
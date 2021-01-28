package com.pt.core.controller.fragment.standalone.viewmodel

import com.pt.core.controller.fragment.standalone.basic.StandAloneStateSavedHandlerFragmentController
import com.pt.core.controller.viewmodel.savedstatehandle.StateSavedHandlerViewModelController

abstract class StandAloneStateSavedHandlerWithViewModelFragmentController :
    StandAloneStateSavedHandlerFragmentController() {
    abstract val viewModel: StateSavedHandlerViewModelController
}
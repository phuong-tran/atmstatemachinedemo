package com.pt.core.controller.viewmodel.savedstatehandle

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateSavedHandlerViewModelController(stateContext: StateContextSavedHandlerProvider) :
    ViewModelBaseWithTransitionListener(), StateContextSavedHandlerProvider by stateContext

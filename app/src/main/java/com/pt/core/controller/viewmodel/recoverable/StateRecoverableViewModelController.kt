package com.pt.core.controller.viewmodel.recoverable

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateContextBundleStorageProvider

abstract class StateRecoverableViewModelController(stateContext: StateContextBundleStorageProvider) :
    ViewModelBaseWithTransitionListener(), StateContextBundleStorageProvider by stateContext
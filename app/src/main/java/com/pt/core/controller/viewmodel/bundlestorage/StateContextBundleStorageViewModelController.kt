package com.pt.core.controller.viewmodel.bundlestorage

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateContextBundleStorageProvider

abstract class StateContextBundleStorageViewModelController(stateContext: StateContextBundleStorageProvider) :
    ViewModelBaseWithTransitionListener(), StateContextBundleStorageProvider by stateContext



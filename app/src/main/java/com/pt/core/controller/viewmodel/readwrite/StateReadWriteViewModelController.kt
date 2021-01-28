package com.pt.core.controller.viewmodel.readwrite

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateContextReadWriteProvider

abstract class StateReadWriteViewModelController(stateContext: StateContextReadWriteProvider) :
    ViewModelBaseWithTransitionListener(), StateContextReadWriteProvider by stateContext
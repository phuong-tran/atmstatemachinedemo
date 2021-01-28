package com.pt.core.controller.viewmodel.recoverable

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateContextReadWriteProvider

abstract class StateRecoverableViewModelController(stateContext: StateContextReadWriteProvider) :
    ViewModelBaseWithTransitionListener(), StateContextReadWriteProvider by stateContext
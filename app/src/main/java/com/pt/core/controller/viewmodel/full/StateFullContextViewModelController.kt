package com.pt.core.controller.viewmodel.full

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.StateFullContextProvider

abstract class StateFullContextViewModelController(stateContext: StateFullContextProvider) :
    ViewModelBaseWithTransitionListener(), StateFullContextProvider by stateContext



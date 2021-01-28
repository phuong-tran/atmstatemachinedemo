package com.pt.core.controller.viewmodel.full

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.FullStateContextProvider

abstract class FullStateContextViewModelController(stateContext: FullStateContextProvider) :
    ViewModelBaseWithTransitionListener(), FullStateContextProvider by stateContext



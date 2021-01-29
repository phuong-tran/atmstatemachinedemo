package com.pt.core.controller.viewmodel.readonly

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider

abstract class StateReadOnlyViewModelController(stateContext: StateContextReadOnlyProvider) :
    ViewModelBaseWithTransitionListener(), StateContextReadOnlyProvider by stateContext
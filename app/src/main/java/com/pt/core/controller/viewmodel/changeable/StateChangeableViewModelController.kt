package com.pt.core.controller.viewmodel.changeable

import com.pt.core.controller.viewmodel.ViewModelBaseWithTransitionListener
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StateChangeableViewModelController(stateContext: StateContextChangeableProvider) :
    ViewModelBaseWithTransitionListener(), StateContextChangeableProvider by stateContext
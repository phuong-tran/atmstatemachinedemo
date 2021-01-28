package com.pt.core.controller.viewmodel

import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StateBasicViewModel(protected val stateContext: StateContextReadOnlyProvider) :
    ViewModelBaseWithTransitionListener()
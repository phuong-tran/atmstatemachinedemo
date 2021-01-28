package com.pt.core1.navigator.viewmodel

import com.pt.core1.state.provider.template.StateContextReadOnlyProvider

abstract class StateBasicViewModel(protected val stateContext: StateContextReadOnlyProvider) :
    ViewModelBaseWithTransitionListener()
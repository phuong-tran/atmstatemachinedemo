package com.pt.core1.navigator.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StateSavedHandlerViewModel(
    protected val savedStateHandle: SavedStateHandle,
    protected val stateContext: StateContextReadOnlyProvider
) :
    ViewModelBaseWithTransitionListener()
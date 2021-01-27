package com.pt.core1.navigator.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.state.provider.CurrentStateGetterProvider
import com.pt.core1.state.provider.SaveStateToSavedHandlerProvider

abstract class StateSavedHandlerViewModel(
    protected val savedStateHandle: SavedStateHandle,
    protected val currentState: CurrentStateGetterProvider,
    protected val savedHandlerProvider: SaveStateToSavedHandlerProvider
) :
    ViewModelBaseWithTransitionListener()
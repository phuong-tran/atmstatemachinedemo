package com.pt.core.controller.viewmodel

import androidx.lifecycle.SavedStateHandle
import com.pt.core.state.provider.CurrentStateGetterProvider
import com.pt.core.state.provider.SaveStateToSavedHandlerProvider

abstract class StateSavedHandlerViewModel(
    protected val savedStateHandle: SavedStateHandle,
    protected val currentState: CurrentStateGetterProvider,
    protected val savedHandlerProvider: SaveStateToSavedHandlerProvider
) :
    ViewModelBaseWithTransitionListener()
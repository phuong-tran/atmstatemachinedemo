package com.pt.core1.navigator.viewmodel.standalone

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.navigator.viewmodel.ViewModelStateBase
import com.pt.core1.state.provider.context.template.StateContextSavedHandler

abstract class StandAloneSavedHandlerStateViewModelController(protected val savedStateHandle: SavedStateHandle) :
    ViewModelStateBase() {
    protected abstract val stateContext: StateContextSavedHandler
}
package com.pt.core.controller.viewmodel.standalone

import androidx.lifecycle.SavedStateHandle
import com.pt.core.controller.viewmodel.ViewModelStateBase
import com.pt.core.state.provider.template.StateContextSavedHandler

abstract class StandAloneSavedHandlerStateViewModelController(protected val savedStateHandle: SavedStateHandle) :
    ViewModelStateBase() {
    protected abstract val stateContext: StateContextSavedHandler
}
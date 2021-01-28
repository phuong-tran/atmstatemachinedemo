package com.pt.core.controller.viewmodel.standalone

import com.pt.core.controller.viewmodel.ViewModelStateBase
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StandAloneSavedHandlerStateViewModelController :
    ViewModelStateBase() {
    protected abstract val stateContext: StateContextSavedHandlerProvider
}
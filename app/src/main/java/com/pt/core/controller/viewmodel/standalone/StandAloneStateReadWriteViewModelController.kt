package com.pt.core.controller.viewmodel.standalone

import com.pt.core.controller.viewmodel.ViewModelStateBase
import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StandAloneStateReadWriteViewModelController : ViewModelStateBase() {
    protected abstract val stateContext: StateContextReadOnlyProvider
}
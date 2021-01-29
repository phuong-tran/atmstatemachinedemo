package com.pt.core.controller.viewmodel.standalone

import com.pt.core.controller.viewmodel.ViewModelStateBase
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyStateMachineProvider

abstract class StandAloneStateChangeableViewModelController : ViewModelStateBase() {
    protected abstract val stateContext: StateContextReadOnlyStateMachineProvider
}
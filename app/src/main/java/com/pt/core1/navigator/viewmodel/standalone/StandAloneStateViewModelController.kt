package com.pt.core1.navigator.viewmodel.standalone

import com.pt.core1.navigator.viewmodel.ViewModelStateBase
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StandAloneStateViewModelController : ViewModelStateBase() {
    protected abstract val stateContext: StateContextReadOnlyProvider
}
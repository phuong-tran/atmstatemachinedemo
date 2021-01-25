package com.pt.core1.controller.viewmodel.external.simple

import com.pt.core1.controller.viewmodel.base.ViewModelWithTag
import com.pt.core1.state.provider.IStateContextProvider

abstract class SimpleStateSupportViewModel(protected val stateContext: IStateContextProvider) :
    ViewModelWithTag()
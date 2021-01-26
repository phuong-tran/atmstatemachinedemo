package com.pt.core1.controller.viewmodel.external.simple

import com.pt.core1.controller.viewmodel.base.ViewModelWithTag
import com.pt.core1.state.provider.context.IStateContextProvider

abstract class SimpleStateSupportWithDelegateViewModel(stateContext: IStateContextProvider) :
    ViewModelWithTag(),
    IStateContextProvider by stateContext
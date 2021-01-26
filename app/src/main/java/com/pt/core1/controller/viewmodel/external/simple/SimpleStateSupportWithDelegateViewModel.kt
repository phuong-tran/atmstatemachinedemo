package com.pt.core1.controller.viewmodel.external.simple

import com.pt.core1.controller.viewmodel.base.ViewModelWithTag
import com.pt.core1.state.provider.context.template.IStateContextDefaultProvider

abstract class SimpleStateSupportWithDelegateViewModel(stateContext: IStateContextDefaultProvider) :
    ViewModelWithTag(),
    IStateContextDefaultProvider by stateContext
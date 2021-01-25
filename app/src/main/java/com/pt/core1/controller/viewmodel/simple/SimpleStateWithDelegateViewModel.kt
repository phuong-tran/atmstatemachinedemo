package com.pt.core1.controller.viewmodel.simple

import com.pt.core1.controller.viewmodel.ViewModelWithTag
import com.pt.core1.state.provider.IStateContextProvider

abstract class SimpleStateWithDelegateViewModel(stateContextProvider: IStateContextProvider) : ViewModelWithTag(),
    IStateContextProvider by stateContextProvider
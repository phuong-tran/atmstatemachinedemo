package com.pt.core1.controller.viewmodel.advance

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.controller.viewmodel.simple.SimpleStateSupportWithDelegateViewModel
import com.pt.core1.state.provider.IStateContextProvider

abstract class StateSupportWithDelegateViewModel(
    private val savedStateHandle: SavedStateHandle,
    stateContextProvider: IStateContextProvider
) : SimpleStateSupportWithDelegateViewModel(stateContextProvider)
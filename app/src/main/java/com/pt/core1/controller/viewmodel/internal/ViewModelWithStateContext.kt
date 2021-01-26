package com.pt.core1.controller.viewmodel.internal

import com.pt.core1.controller.viewmodel.base.ViewModelWithTag
import com.pt.core1.state.provider.context.IStateContextProvider

/**
 * State will be lost once the context is Destroyed
 */
abstract class ViewModelWithStateContext : ViewModelWithTag() {
    protected abstract val stateContext: IStateContextProvider
}
package com.pt.app1.viewmodel.template.simple

import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportWithDelegateViewModel
import com.pt.core1.state.provider.template.StateContextDefaultProvider

class SimpleStateSupportTemplateWithDelegateViewModel(stateContext: StateContextDefaultProvider) :
    SimpleStateSupportWithDelegateViewModel(stateContext) {
    override val TAG = "SimpleStateSupportTemplateWithDelegateViewModel"

    /*class Factory(
        private val stateContext: IStateContextProvider,
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SimpleStateSupportTemplateWithDelegateViewModel(stateContext) as T
        }
    }*/
}
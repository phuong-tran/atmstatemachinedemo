package com.pt.app1.viewmodel.template.simple

import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportViewModel
import com.pt.core1.state.provider.IStateContextProvider

class SimpleStateSupportTemplateViewModel(stateContext: IStateContextProvider) :
    SimpleStateSupportViewModel(stateContext) {
    override val TAG: String = "SimpleStateSupportTemplateViewModel"

    /*class Factory(
        private val stateContext: IStateContextProvider,
    ) : ViewModelProvider.Factory  {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SimpleStateSupportTemplateViewModel(stateContext) as T
        }
    }*/
}
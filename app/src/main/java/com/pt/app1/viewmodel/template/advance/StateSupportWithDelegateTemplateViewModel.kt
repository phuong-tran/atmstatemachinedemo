package com.pt.app1.viewmodel.template.advance

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.controller.viewmodel.external.advance.StateSupportWithDelegateViewModel
import com.pt.core1.state.provider.context.IStateContextProvider

class StateSupportWithDelegateTemplateViewModel(
    savedStateHandle: SavedStateHandle,
    stateContext: IStateContextProvider
) : StateSupportWithDelegateViewModel(savedStateHandle, stateContext) {
    override val TAG = "StateSupportWithDelegateTemplateViewModel"

    /*class Factory(
        owner: SavedStateRegistryOwner,
        private val stateContext: IStateContextProvider,
        defaultArgs: Bundle? = null
    ) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return StateSupportWithDelegateTemplateViewModel(handle, stateContext) as T
        }
    }*/
}
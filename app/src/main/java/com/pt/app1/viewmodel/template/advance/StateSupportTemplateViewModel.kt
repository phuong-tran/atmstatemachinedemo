package com.pt.app1.viewmodel.template.advance

import androidx.lifecycle.SavedStateHandle
import com.pt.core1.controller.viewmodel.external.advance.StateSupportViewModel
import com.pt.core1.state.provider.context.template.StateContextDefaultProvider

class StateSupportTemplateViewModel(
    savedStateHandle: SavedStateHandle,
    stateContext: StateContextDefaultProvider
) : StateSupportViewModel(savedStateHandle, stateContext) {
    override val TAG = "StateSupportTemplateViewModel"


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
            return StateSupportTemplateViewModel(handle, stateContext) as T
        }
    }*/
}

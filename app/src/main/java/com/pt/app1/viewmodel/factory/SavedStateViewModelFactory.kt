package com.pt.app1.viewmodel.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.pt.core1.state.provider.IStateContextProvider

class SavedStateViewModelFactory(
    owner: SavedStateRegistryOwner,
    private val stateContext: IStateContextProvider,
    private val initializer: (savedStateHandle: SavedStateHandle, stateContext: IStateContextProvider) -> ViewModel,
    defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return initializer(handle, stateContext) as T
    }
}
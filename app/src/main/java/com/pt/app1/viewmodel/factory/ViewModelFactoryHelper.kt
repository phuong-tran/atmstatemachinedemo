package com.pt.app1.viewmodel.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner
import com.pt.core1.state.provider.IStateContextProvider

inline fun <reified VM : ViewModel> createFactory(noinline initializer: () -> ViewModel): ViewModelProvider.Factory {
    val vmClass = VM::class.java
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (vmClass != modelClass) {
                throw IllegalArgumentException("IllegalArgumentException")
            }
            return initializer() as T
        }
    }
}

inline fun <reified T: ViewModel> createViewModelFactory(crossinline initializer: () -> T): ViewModelProvider.Factory {
    return ViewModelFactory {
        initializer()
    }
}

class ViewModelFactory<out T: ViewModel>(
    private val initializer: () -> T
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return initializer() as T
    }
}


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


/*
inline fun <reified T : ViewModel> createViewModel(noinline initializer: () -> ViewModel) {
    createViewModelFactory { initializer() }.create(T::class.java)
}*/

package com.pt.core.controller.viewmodel.factory

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner

inline fun createDefaultSavedStateViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
    crossinline initializer: (savedStateHandle: SavedStateHandle) -> ViewModel
): AbstractSavedStateViewModelFactory {
    return object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return initializer(handle) as T
        }
    }
}

inline fun <reified VM : ViewModel> createDefaultSavedStateViewModelFactorySafe(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
    crossinline initializer: (savedStateHandle: SavedStateHandle) -> ViewModel
): AbstractSavedStateViewModelFactory {
    val vmClass = VM::class.java
    return object : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            if (vmClass != modelClass) {
                throw IllegalArgumentException("IllegalArgumentException")
            }
            return initializer(handle) as T
        }
    }
}

inline fun <T : ViewModel> createSavedStateViewModelFactory(
    owner: SavedStateRegistryOwner,
    defaultArgs: Bundle? = null,
    crossinline initializer: (savedStateHandle: SavedStateHandle) -> T
): AbstractSavedStateViewModelFactory {
    return SavedStateViewModelFactory(owner, defaultArgs) {
        initializer(it)
    }
}
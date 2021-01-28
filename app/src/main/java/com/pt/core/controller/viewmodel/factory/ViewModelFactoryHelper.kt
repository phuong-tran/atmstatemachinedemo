package com.pt.core.controller.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.pt.core.controller.viewmodel.readonly.StateReadOnlyViewModelController

inline fun createDefaultViewModelFactory(crossinline initializer: () -> ViewModel): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}

inline fun createStateBasicViewModelFactory(crossinline initializer: () -> StateReadOnlyViewModelController): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }
}


inline fun <reified VM : ViewModel> createDefaultViewModelFactorySafe(noinline initializer: () -> ViewModel): ViewModelProvider.Factory {
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

inline fun <reified VM : ViewModel> createStateBasicViewModelFactorySafe(noinline initializer: () -> ViewModel): ViewModelProvider.Factory {
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


inline fun <reified T : ViewModel> createViewModelFactory(crossinline initializer: () -> T): ViewModelProvider.Factory {
    return ViewModelFactory {
        initializer()
    }
}
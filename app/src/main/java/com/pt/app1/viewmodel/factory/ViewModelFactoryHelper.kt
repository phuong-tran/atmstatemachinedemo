package com.pt.app1.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/* val viewModel by viewModels<SimpleStateSupportTemplateViewModel> {
        createFactorySafe<SimpleStateSupportTemplateViewModel> {
            SimpleStateSupportTemplateViewModel(stateContext)
        }
    }


    val viewModel2 by viewModels<SimpleStateSupportTemplateViewModel> {
       createFactory {
           SimpleStateSupportTemplateViewModel(stateContext)
       }
    }

    val viewModel3 by viewModels<SimpleStateSupportTemplateViewModel> {
        createViewModelFactory {
            SimpleStateSupportTemplateViewModel(stateContext)
        }
    }*/

inline fun createDefaultViewModelFactory(crossinline initializer: () -> ViewModel): ViewModelProvider.Factory {
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


inline fun <reified T : ViewModel> createViewModelFactory(crossinline initializer: () -> T): ViewModelProvider.Factory {
    return ViewModelFactory {
        initializer()
    }
}
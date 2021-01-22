package com.pt.core.navigation.viewmodel.statebase

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

abstract class SavedStateHandlerBaseViewModel(protected val savedStateHandle: SavedStateHandle) :
    ViewModel() {
}
package com.pt.app.viewmodel.template

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.pt.core.data.TransitionData
import com.pt.core.controller.viewmodel.StateSavedHandlerViewModel
import com.pt.core.state.provider.CurrentStateGetterProvider
import com.pt.core.state.provider.SaveStateToSavedHandlerProvider


class StateSavedHandlerViewModelImpl(
    savedStateHandle: SavedStateHandle,
    currentState: CurrentStateGetterProvider,
    savedHandlerProvider: SaveStateToSavedHandlerProvider
) : StateSavedHandlerViewModel(savedStateHandle, currentState, savedHandlerProvider) {
    override val TAG: String = "StateSavedHandlerViewModelImpl"
    private val transitionMutableLiveData: MutableLiveData<TransitionData> = MutableLiveData()
    val transitionData: LiveData<TransitionData> = transitionMutableLiveData

    override fun onTransaction(transitionData: TransitionData) {
        savedHandlerProvider.saveAllCurrentStateToSavedStateHandler(savedStateHandle, currentState)
        transitionMutableLiveData.postValue(transitionData)
    }
}

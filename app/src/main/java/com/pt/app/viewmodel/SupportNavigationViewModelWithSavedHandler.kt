package com.pt.app.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.data.transition.TransitionData
import com.pt.state.manager.StateMachine
import com.pt.state.navigation.Navigation
import com.pt.state.navigation.viewmodel.SupportNavigationViewModelWithSavedHandlerBase

interface TransitionHandler {
    fun onTransit(data: TransitionData)
}

class SupportNavigationViewModelWithSavedHandler(
    navigation: Navigation<State, Event, SideEffect>,
    savedStateHandle: SavedStateHandle
) : SupportNavigationViewModelWithSavedHandlerBase(navigation, savedStateHandle), TransitionHandler {
    private val transitionMutableLiveData: MutableLiveData<TransitionData> = MutableLiveData()
    val transitionData: LiveData<TransitionData> = transitionMutableLiveData

    override fun onTransit(data: TransitionData) {
        transitionMutableLiveData.postValue(data)
    }

    class Factory(
        private val navigation: Navigation<State, Event, SideEffect>,
        owner: SavedStateRegistryOwner,
        defaultArgs: Bundle? = null
    ) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            key: String,
            modelClass: Class<T>,
            handle: SavedStateHandle
        ): T {
            return SupportNavigationViewModelWithSavedHandler(navigation, handle) as T
        }
    }
}

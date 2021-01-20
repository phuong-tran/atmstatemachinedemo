package com.pt.app.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.advance.NavigationAdvancedHandler
import com.pt.core.state.advance.TransitionHandler
import com.pt.core.navigation.viewmodel.AdvancedSupportStateBaseViewModel

class SupportNavigationViewModelWithSavedHandler(
    navigation: NavigationAdvancedHandler<State, Event, SideEffect>,
    savedStateHandle: SavedStateHandle
) : AdvancedSupportStateBaseViewModel(navigation, savedStateHandle),
    TransitionHandler {
    private val transitionMutableLiveData: MutableLiveData<TransitionData> = MutableLiveData()
    override val TAG = "SupportNavigationViewModelWithSavedHandler"
    val transitionData: LiveData<TransitionData> = transitionMutableLiveData

    override fun onTransit(data: TransitionData) {
        saveState(data.toState)
        saveTransitionData(data)
        transitionMutableLiveData.postValue(data)
    }

    class Factory(
        private val navigation: NavigationAdvancedHandler<State, Event, SideEffect>,
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

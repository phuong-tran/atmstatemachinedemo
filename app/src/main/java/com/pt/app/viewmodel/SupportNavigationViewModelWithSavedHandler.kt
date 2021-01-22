package com.pt.app.viewmodel

import android.os.Bundle
import androidx.lifecycle.*
import androidx.savedstate.SavedStateRegistryOwner
import com.pt.core.data.transition.TransitionData
import com.pt.core.state.advance.TransitionHandler
import com.pt.core.navigation.viewmodel.statebase.AdvancedSupportStateBaseViewModel
import com.pt.core.state.advance.statebase.NavigationAdvancedHandler

class SupportNavigationViewModelWithSavedHandler(
    navigation: NavigationAdvancedHandler,
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
        private val navigation: NavigationAdvancedHandler,
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

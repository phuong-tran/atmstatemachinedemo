package com.pt.core1.controller.fragment.basic


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.StateContextProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.helper.getStateFromBundle

abstract class BasicStateFragment : Fragment(),
    GraphBuilderProvider, TransactionActionProvider, DefaultStateProvider {
    abstract val TAG: String
    abstract val stateContextProvider: StateContextProvider

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(stateContextProvider) {
            saveAllCurrentStateToBundle(outState, getCurrentState(), getCurrentTransitionData())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            //val transitionData = savedInstanceState.getTransitionDataFromBundle()
            savedInstanceState.getStateFromBundle()?.let {
                stateContextProvider.setNewState(it)
            }
        }
    }
}
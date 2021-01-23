package com.pt.core1.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.StateContextProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.helper.getStateFromBundle

abstract class BasicStateActivity : AppCompatActivity(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {

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
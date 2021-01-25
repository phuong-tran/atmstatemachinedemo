package com.pt.core1.controller.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.helper.getStateFromBundle

abstract class BasicStateActivity : AppCompatActivity(), IGraphBuilderProvider,
    ITransactionActionProvider, IDefaultStateProvider {

    abstract val TAG: String
    abstract val stateContextProvider: IStateContextProvider

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
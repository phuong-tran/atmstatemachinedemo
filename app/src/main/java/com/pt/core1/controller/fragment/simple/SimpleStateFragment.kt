package com.pt.core1.controller.fragment.simple


import android.os.Bundle
import androidx.fragment.app.Fragment
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider

abstract class SimpleStateFragment : FragmentWithTag(),
    IGraphBuilderProvider, ITransactionActionProvider, IDefaultStateProvider {
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
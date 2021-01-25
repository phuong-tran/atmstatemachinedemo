package com.pt.core1.controller.fragment.simple


import android.os.Bundle
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.helper.getTransitionDataFromBundle
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider

abstract class SimpleStateFragment : FragmentWithTag(),
    IGraphBuilderProvider, ITransactionActionProvider, IDefaultStateProvider {
    abstract val stateContext: IStateContextProvider


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(stateContext) {
            saveAllCurrentStateToBundle(outState, getCurrentState(), getCurrentTransitionData())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            with(stateContext) {
                savedInstanceState.getStateFromBundle()?.let {
                    setCurrentState(it)
                    setNewState(it)

                }
                savedInstanceState.getTransitionDataFromBundle()?.let {
                    setTransitionData(it)
                }
            }
        }
    }
}
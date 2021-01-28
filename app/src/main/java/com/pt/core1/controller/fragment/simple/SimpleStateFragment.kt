package com.pt.core1.controller.fragment.simple

import android.os.Bundle
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.helper.getTransitionDataFromBundle
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.template.StateContextDefaultProvider
import com.pt.core1.state.provider.TransactionActionProvider

abstract class SimpleStateFragment : FragmentWithTag(),
    GraphBuilderProvider, TransactionActionProvider, DefaultStateProvider {
    abstract val stateContext: StateContextDefaultProvider

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
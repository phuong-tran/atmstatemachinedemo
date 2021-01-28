package com.pt.core1.controller.activity.simple

import android.os.Bundle
import com.pt.core1.controller.activity.ActivityWithTag
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.template.StateContextDefaultProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.helper.getTransitionDataFromBundle

abstract class SimpleStateActivity : ActivityWithTag(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
    protected abstract val stateContext: StateContextDefaultProvider

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
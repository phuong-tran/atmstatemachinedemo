package com.pt.core.controller.activity.standalone

import android.os.Bundle
import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.helper.getStateFromBundle
import com.pt.core.state.helper.getTransitionDataFromBundle
import com.pt.core.state.manager.StateContextBundleStorageProviderTemplate
import com.pt.core.state.provider.template.StateContextBundleStorageProvider

abstract class StateReadWriteActivityController : StateBaseActivity() {
    override val TAG = "StateRecoverableActivityController"
    protected open val stateContext: StateContextBundleStorageProvider by lazy {
        StateContextBundleStorageProviderTemplate.create(this, this, this)
    }

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

package com.pt.core1.navigator.activity.basic

import android.os.Bundle
import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.helper.getTransitionDataFromBundle
import com.pt.core1.state.manager.StateContextBundleStorageProviderTemplate
import com.pt.core1.state.provider.context.template.StateContextBundleStorageProvider

abstract class StateSupportBundleStorageActivityController : StateBaseActivity() {
    override val TAG = "StateSupportBundleStorageActivityController"
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

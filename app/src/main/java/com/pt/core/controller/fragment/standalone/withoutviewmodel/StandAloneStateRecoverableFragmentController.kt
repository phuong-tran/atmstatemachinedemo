package com.pt.core.controller.fragment.standalone.withoutviewmodel

import android.os.Bundle
import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.helper.getStateFromBundle
import com.pt.core.state.helper.getTransitionDataFromBundle
import com.pt.core.state.manager.StateContextBundleStorageProviderTemplate
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StandAloneStateRecoverableFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextBundleStorageProvider by lazy {
        StateContextBundleStorageProviderTemplate.create(this, this, this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(stateContext) {
            saveStateToBundle(outState, getCurrentState())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            with(stateContext) {
                savedInstanceState.getStateFromBundle()?.let {
                    setNewState(it)
                }
            }
        }
    }
}
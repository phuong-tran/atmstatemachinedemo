package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.manager.StateContextReadWriteProviderTemplate
import com.pt.core1.state.provider.template.StateContextReadWriteProvider

abstract class StateReadWriteActivityController : StateBaseActivity() {
    override val TAG = "StateReadWriteActivityController"
    protected val stateContext: StateContextReadWriteProvider by lazy {
        StateContextReadWriteProviderTemplate.create(this, this, this)
    }
}
package com.pt.core.controller.activity.basic

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextReadWriteProviderTemplate
import com.pt.core.state.provider.template.StateContextReadWriteProvider

abstract class StateReadWriteActivityController : StateBaseActivity() {
    override val TAG = "StateReadWriteActivityController"
    protected val stateContext: StateContextReadWriteProvider by lazy {
        StateContextReadWriteProviderTemplate.create(this, this, this)
    }
}
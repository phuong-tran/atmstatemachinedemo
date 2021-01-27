package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.provider.context.template.StateContextReadWriteProvider

abstract class StateReadWriteActivityController : StateBaseActivity() {
    override val TAG = "StateReadWriteActivityController"
    protected abstract val stateContext: StateContextReadWriteProvider
}
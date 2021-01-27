package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StateReadOnlyActivityController : StateBaseActivity() {
    override val TAG = "StateReadOnlyActivityController"
    protected abstract val stateContext: StateContextReadOnlyProvider
}
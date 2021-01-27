package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core1.state.provider.context.template.StateContextReadOnlyProvider

abstract class StateReadOnlyActivityController : StateBaseActivity() {
    override val TAG = "StateReadOnlyActivityController"
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
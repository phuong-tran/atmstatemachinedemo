package com.pt.core.controller.activity.standalone

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StateReadOnlyActivityController : StateBaseActivity() {
    override val TAG = "StateReadOnlyActivityController"
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
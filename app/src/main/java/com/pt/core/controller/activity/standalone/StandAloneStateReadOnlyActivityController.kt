package com.pt.core.controller.activity.standalone

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StandAloneStateReadOnlyActivityController : StateBaseActivity() {
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
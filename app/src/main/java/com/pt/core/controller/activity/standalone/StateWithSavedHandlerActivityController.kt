package com.pt.core.controller.activity.standalone

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextSavedHandlerTemplate
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateWithSavedHandlerActivityController : StateBaseActivity() {
    override val TAG = "StateWithSavedHandlerActivityController"
    protected val stateContext: StateContextSavedHandlerProvider by lazy {
        StateContextSavedHandlerTemplate.create(this, this, this)
    }
}
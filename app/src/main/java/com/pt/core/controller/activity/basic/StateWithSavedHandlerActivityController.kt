package com.pt.core.controller.activity.basic

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextSavedHandlerTemplate
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StateWithSavedHandlerActivityController : StateBaseActivity() {
    override val TAG = "StateSupportSavedHandlerStorageActivityController"
    protected val stateContext: StateContextSavedHandlerProvider by lazy {
        StateContextSavedHandlerTemplate.create(this, this, this)
    }
}
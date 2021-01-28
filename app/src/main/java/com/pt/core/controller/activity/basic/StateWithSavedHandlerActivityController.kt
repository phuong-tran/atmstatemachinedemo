package com.pt.core.controller.activity.basic

import com.pt.core.controller.activity.StateBaseActivity
import com.pt.core.state.manager.StateContextSavedHandlerStorageTemplate
import com.pt.core.state.provider.template.StateContextSavedHandler

abstract class StateWithSavedHandlerActivityController : StateBaseActivity() {
    override val TAG = "StateSupportSavedHandlerStorageActivityController"
    protected val stateContext: StateContextSavedHandler by lazy {
        StateContextSavedHandlerStorageTemplate.create(this, this, this)
    }
}
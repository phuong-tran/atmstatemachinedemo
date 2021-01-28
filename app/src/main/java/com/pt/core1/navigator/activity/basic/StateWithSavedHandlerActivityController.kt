package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.manager.StateContextSavedHandlerStorageTemplate
import com.pt.core1.state.provider.context.template.StateContextSavedHandler

abstract class StateWithSavedHandlerActivityController : StateBaseActivity() {
    override val TAG = "StateSupportSavedHandlerStorageActivityController"
    protected val stateContext: StateContextSavedHandler by lazy {
        StateContextSavedHandlerStorageTemplate.create(this, this, this)
    }
}
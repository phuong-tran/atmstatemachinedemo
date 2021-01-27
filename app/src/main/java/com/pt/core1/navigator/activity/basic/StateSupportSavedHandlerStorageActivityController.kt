package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.manager.StateContextSavedHandlerStorageTemplate
import com.pt.core1.state.provider.context.template.StateContextSavedHandlerStorage

abstract class StateSupportSavedHandlerStorageActivityController : StateBaseActivity() {
    override val TAG = "StateSupportSavedHandlerStorageActivityController"
    protected val stateContext: StateContextSavedHandlerStorage by lazy {
        StateContextSavedHandlerStorageTemplate.create(this, this, this)
    }
}
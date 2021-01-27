package com.pt.core1.navigator.activity.basic

import com.pt.core1.navigator.activity.StateBaseActivity
import com.pt.core1.state.provider.context.template.StateContextSavedHandlerStorage

abstract class StateSupportSavedHandlerStorageActivityController : StateBaseActivity() {
    override val TAG = "StateSupportSavedHandlerStorageActivityController"
    protected abstract val stateContext: StateContextSavedHandlerStorage
}
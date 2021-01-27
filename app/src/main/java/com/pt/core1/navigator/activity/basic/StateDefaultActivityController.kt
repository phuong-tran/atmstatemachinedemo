package com.pt.core1.navigator.activity.basic

import com.pt.core1.state.provider.context.template.DefaultStateContextProvider

abstract class StateDefaultActivityController : StateSupportBundleStorageActivityController() {
    override val TAG = "StateDefaultActivityController"
    protected abstract val defaultContext: DefaultStateContextProvider
}
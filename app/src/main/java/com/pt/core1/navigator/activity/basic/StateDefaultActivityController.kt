package com.pt.core1.navigator.activity.basic

import com.pt.core1.state.provider.context.template.DefaultStateContextProvider

abstract class StateDefaultActivityController : StateSupportBundleStorageActivityController() {
    override val TAG = "StateReadOnlyActivityController"
    protected abstract val defaultContext: DefaultStateContextProvider
}
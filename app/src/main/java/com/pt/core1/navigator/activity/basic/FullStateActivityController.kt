package com.pt.core1.navigator.activity.basic

import com.pt.core1.state.manager.FullStateContextProviderTemplate
import com.pt.core1.state.provider.template.FullStateContextProvider

abstract class FullStateActivityController : StateRecoverableActivityController() {
    override val TAG = "StateDefaultActivityController"

    final override val stateContext: FullStateContextProvider by lazy {
        FullStateContextProviderTemplate.create(this, this, this)
    }
}
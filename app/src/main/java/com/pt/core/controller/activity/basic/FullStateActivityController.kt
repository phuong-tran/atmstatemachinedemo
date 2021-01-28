package com.pt.core.controller.activity.basic

import com.pt.core.state.manager.FullStateContextProviderTemplate
import com.pt.core.state.provider.template.FullStateContextProvider

abstract class FullStateActivityController : StateRecoverableActivityController() {
    override val TAG = "FullStateActivityController"

    final override val stateContext: FullStateContextProvider by lazy {
        FullStateContextProviderTemplate.create(this, this, this)
    }
}
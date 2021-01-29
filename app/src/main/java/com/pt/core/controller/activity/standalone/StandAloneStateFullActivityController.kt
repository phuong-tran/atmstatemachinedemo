package com.pt.core.controller.activity.standalone

import com.pt.core.state.manager.StateFullContextProviderTemplate
import com.pt.core.state.provider.template.StateFullContextProvider

abstract class StandAloneStateFullActivityController : StandAloneStateRecoverableActivityController() {
    final override val stateContext: StateFullContextProvider by lazy {
        StateFullContextProviderTemplate.create(this, this, this)
    }
}
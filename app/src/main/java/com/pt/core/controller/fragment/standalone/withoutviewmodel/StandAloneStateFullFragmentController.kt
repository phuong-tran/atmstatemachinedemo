package com.pt.core.controller.fragment.standalone.withoutviewmodel

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateFullContextProviderTemplate
import com.pt.core.state.provider.template.StateFullContextProvider

abstract class StandAloneStateFullFragmentController : StateBaseFragment() {
    protected val stateContext: StateFullContextProvider by lazy {
        StateFullContextProviderTemplate.create(this, this, this)
    }
}
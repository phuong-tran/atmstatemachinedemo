package com.pt.core.controller.fragment.standalone.withoutviewmodel

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateContexChangeableProviderTemplate
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

abstract class StandAloneStateChangeableFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextChangeableProvider by lazy {
        StateContexChangeableProviderTemplate.create(this, this, this)
    }
}
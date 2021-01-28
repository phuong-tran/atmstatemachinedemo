package com.pt.core.controller.fragment.standalone.basic

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core.state.provider.template.StateContextReadOnlyProvider

abstract class StandAloneStateReadOnlyFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
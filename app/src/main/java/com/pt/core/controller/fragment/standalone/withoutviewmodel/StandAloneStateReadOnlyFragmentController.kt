package com.pt.core.controller.fragment.standalone.withoutviewmodel

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider

abstract class StandAloneStateReadOnlyFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
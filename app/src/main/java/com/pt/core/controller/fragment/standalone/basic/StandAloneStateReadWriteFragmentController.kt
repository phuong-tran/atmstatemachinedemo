package com.pt.core.controller.fragment.standalone.basic

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateContextReadWriteProviderTemplate
import com.pt.core.state.provider.template.StateContextReadWriteProvider

abstract class StandAloneStateReadWriteFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextReadWriteProvider by lazy {
        StateContextReadWriteProviderTemplate.create(this, this, this)
    }
}
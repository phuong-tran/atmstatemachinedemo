package com.pt.core.controller.fragment.standalone.withoutviewmodel

import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.state.manager.StateContextSavedHandlerTemplate
import com.pt.core.state.provider.template.StateContextSavedHandlerProvider

abstract class StandAloneStateSavedHandlerFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextSavedHandlerProvider by lazy {
        StateContextSavedHandlerTemplate.create(this, this, this)
    }
}
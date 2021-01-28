package com.pt.core1.navigator.fragment.standalone

import com.pt.core1.navigator.fragment.StateBaseFragment
import com.pt.core1.state.manager.StateContextReadOnlyProviderTemplate
import com.pt.core1.state.provider.template.StateContextReadOnlyProvider

abstract class StandAloneStateReadOnlyFragmentController : StateBaseFragment() {
    protected val stateContext: StateContextReadOnlyProvider by lazy {
        StateContextReadOnlyProviderTemplate.create(this, this, this)
    }
}
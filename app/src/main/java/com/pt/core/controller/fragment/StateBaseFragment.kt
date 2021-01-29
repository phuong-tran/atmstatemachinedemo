package com.pt.core.controller.fragment

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider

abstract class StateBaseFragment : BaseFragment(), GraphBuilderProvider,
    StateTransactionDataProvider, DefaultStateProvider {
}
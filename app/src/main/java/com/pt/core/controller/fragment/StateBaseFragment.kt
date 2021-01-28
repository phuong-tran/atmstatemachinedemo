package com.pt.core.controller.fragment

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.TransactionActionProvider

abstract class StateBaseFragment : BaseFragment(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
}
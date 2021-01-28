package com.pt.core1.navigator.fragment

import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider

abstract class StateBaseFragment : BaseFragment(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
}
package com.pt.core.controller.fragment

import androidx.annotation.LayoutRes
import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider

abstract class StateBaseFragment(@LayoutRes layoutId: Int = 0) : BaseFragment(layoutId), GraphBuilderProvider,
    StateTransactionDataProvider, DefaultStateProvider {
}
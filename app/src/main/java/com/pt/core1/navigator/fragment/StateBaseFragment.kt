package com.pt.core1.navigator.fragment

import androidx.fragment.app.Fragment
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider

abstract class StateBaseFragment : Fragment(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
    protected abstract val TAG: String
}
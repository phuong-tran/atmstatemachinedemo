package com.pt.core1.navigator.viewmodel

import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider

abstract class ViewModelStateBase : ViewModelBase(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
}
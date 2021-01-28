package com.pt.core.controller.viewmodel

import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.TransactionActionProvider

abstract class ViewModelStateBase : ViewModelBase(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
}
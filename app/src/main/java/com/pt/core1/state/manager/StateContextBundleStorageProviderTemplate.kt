package com.pt.core1.state.manager

import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.SaveStateToBundleProvider
import com.pt.core1.state.provider.TransactionActionProvider
import com.pt.core1.state.provider.context.template.StateContextReadWriteProvider
import com.pt.core1.state.provider.context.template.StateContextBundleStorageProvider

class StateContextBundleStorageProviderTemplate private constructor(
    defaultStateProvider: DefaultStateProvider,
    graphBuilderProvider: GraphBuilderProvider,
    transactionActionProvider: TransactionActionProvider,
) : StateContextBundleStorageProvider,
    StateContextReadWriteProvider by StateContextReadWriteProviderTemplate.create(
        defaultStateProvider = defaultStateProvider,
        graphBuilderProvider = graphBuilderProvider,
        transactionActionProvider = transactionActionProvider
    )



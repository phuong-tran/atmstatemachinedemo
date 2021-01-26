package com.pt.core1.state.manager

import com.pt.core1.state.provider.*

class DefaultStateContextProvider(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider
) : MutableStateContextProvider(
    defaultStateProvider = defaultStateProvider,
    graphBuilderProvider = graphBuilderProvider,
    transactionActionProvider = transactionActionProvider
), ISaveStateToBundleProvider by SaveStateToBundleProvider,
    ISaveStateToSavedHandlerProvider by SaveStateToSavedHandlerProvider
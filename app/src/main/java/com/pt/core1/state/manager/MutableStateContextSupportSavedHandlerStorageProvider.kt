package com.pt.core1.state.manager

import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.ISaveStateToSavedHandlerProvider
import com.pt.core1.state.provider.ITransactionActionProvider

class MutableStateContextSupportSavedHandlerStorageProvider(
    defaultStateProvider: IDefaultStateProvider,
    graphBuilderProvider: IGraphBuilderProvider,
    transactionActionProvider: ITransactionActionProvider
) : MutableStateContextProvider(
    defaultStateProvider = defaultStateProvider,
    graphBuilderProvider = graphBuilderProvider,
    transactionActionProvider = transactionActionProvider
), ISaveStateToSavedHandlerProvider by SaveStateToSavedHandlerProvider
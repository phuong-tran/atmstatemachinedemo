package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.ISaveStateToBundleProvider
import com.pt.core1.state.provider.ISaveStateToSavedHandlerProvider

interface IDefaultStateContextProvider : IMutableStateContextProvider, ISaveStateToBundleProvider,
    ISaveStateToSavedHandlerProvider
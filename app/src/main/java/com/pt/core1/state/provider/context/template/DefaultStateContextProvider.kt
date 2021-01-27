package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.SaveStateToBundleProvider
import com.pt.core1.state.provider.SaveStateToSavedHandlerProvider

interface DefaultStateContextProvider : StateContextReadWriteProvider, SaveStateToBundleProvider,
    SaveStateToSavedHandlerProvider
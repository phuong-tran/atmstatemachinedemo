package com.pt.core.state.provider.template

import com.pt.core.state.provider.SaveStateToSavedHandlerProvider
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

interface StateFullContextProvider : StateContextBundleStorageProvider,
    SaveStateToSavedHandlerProvider
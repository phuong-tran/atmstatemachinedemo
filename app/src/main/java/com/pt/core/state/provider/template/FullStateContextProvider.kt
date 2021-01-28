package com.pt.core.state.provider.template

import com.pt.core.state.provider.SaveStateToSavedHandlerProvider

interface FullStateContextProvider : StateContextBundleStorageProvider,
    SaveStateToSavedHandlerProvider
package com.pt.core1.state.provider.template

import com.pt.core1.state.provider.SaveStateToSavedHandlerProvider

interface FullStateContextProvider : StateContextBundleStorageProvider,
    SaveStateToSavedHandlerProvider
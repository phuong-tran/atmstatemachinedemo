package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.SaveStateToSavedHandlerProvider

interface StateContextSavedHandlerStorage : StateContextReadWriteProvider,
    SaveStateToSavedHandlerProvider
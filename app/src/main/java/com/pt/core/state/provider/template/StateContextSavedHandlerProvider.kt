package com.pt.core.state.provider.template

import com.pt.core.state.provider.SaveStateToSavedHandlerProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

interface StateContextSavedHandlerProvider : StateContextChangeableProvider,
    SaveStateToSavedHandlerProvider
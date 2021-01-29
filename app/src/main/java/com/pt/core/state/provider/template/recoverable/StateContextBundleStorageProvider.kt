package com.pt.core.state.provider.template.recoverable

import com.pt.core.state.provider.SaveStateToBundleProvider
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider

interface StateContextBundleStorageProvider : StateContextChangeableProvider,
    SaveStateToBundleProvider
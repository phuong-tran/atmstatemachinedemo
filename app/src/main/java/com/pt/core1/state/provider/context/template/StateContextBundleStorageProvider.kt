package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.SaveStateToBundleProvider

interface StateContextBundleStorageProvider : StateContextReadWriteProvider,
    SaveStateToBundleProvider
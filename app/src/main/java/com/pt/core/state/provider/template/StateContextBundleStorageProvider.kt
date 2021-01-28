package com.pt.core.state.provider.template

import com.pt.core.state.provider.SaveStateToBundleProvider

interface StateContextBundleStorageProvider : StateContextReadWriteProvider,
    SaveStateToBundleProvider
package com.pt.core.state.provider.template.changeable

import com.pt.core.state.provider.template.readonly.StateContextReadOnlyProvider
import com.pt.core.state.provider.transition.ChangeStateProvider

interface StateContextChangeableProvider : StateContextReadOnlyProvider, ChangeStateProvider
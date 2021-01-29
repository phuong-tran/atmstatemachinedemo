package com.pt.core.state.provider.template.readonly

import com.pt.core.state.provider.CurrentStateGetterProvider
import com.pt.core.state.provider.transition.StateTransitionProvider

interface StateContextReadOnlyProvider : StateTransitionProvider, CurrentStateGetterProvider
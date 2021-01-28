package com.pt.core.state.provider.template

import com.pt.core.state.provider.CurrentStateGetterProvider
import com.pt.core.state.provider.CurrentStateSetterProvider

interface StateHolderProvider : CurrentStateSetterProvider, CurrentStateGetterProvider
package com.pt.core1.state.provider.template

import com.pt.core1.state.provider.CurrentStateGetterProvider
import com.pt.core1.state.provider.CurrentStateSetterProvider

interface StateHolderProvider : CurrentStateSetterProvider, CurrentStateGetterProvider
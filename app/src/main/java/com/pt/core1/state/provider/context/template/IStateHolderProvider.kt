package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.ICurrentStateGetterProvider
import com.pt.core1.state.provider.ICurrentStateSetterProvider

interface IStateHolderProvider : ICurrentStateSetterProvider, ICurrentStateGetterProvider
package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.*

interface IStateContextProvider :
    IStateMachineProvider,
    IStateTransitionProvider,
    ICurrentStateSetterProvider,
    ICurrentStateGetterProvider
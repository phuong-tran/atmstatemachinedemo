package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.*

interface StateContextProvider :
    StateMachineProvider,
    StateTransitionProvider,
    CurrentStateSetterProvider,
    CurrentStateGetterProvider
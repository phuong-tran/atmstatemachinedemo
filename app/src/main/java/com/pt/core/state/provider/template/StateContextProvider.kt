package com.pt.core.state.provider.template

import com.pt.core.state.provider.*

interface StateContextProvider :
    StateMachineProvider,
    StateTransitionProvider,
    CurrentStateSetterProvider,
    CurrentStateGetterProvider
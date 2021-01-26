package com.pt.core1.state.provider.context.template

import com.pt.core1.state.provider.*

interface IImmutableStateContextProvider :
    IStateMachineCreatorProvider,
    IStateTransitionProvider,
    ICurrentStateSetterProvider,
    ICurrentStateGetterProvider {
    fun transactionActionProvider(): ITransactionActionProvider
}
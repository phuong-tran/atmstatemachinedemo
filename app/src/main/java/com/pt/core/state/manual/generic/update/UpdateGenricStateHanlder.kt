package com.pt.core.state.manual.generic.update

interface UpdateGenericState<State> {
    fun setCurrentState(state: State)
}
package com.pt.core.state.manual.update

interface UpdateGenericState<State> {
    fun setCurrentState(state: State)
}
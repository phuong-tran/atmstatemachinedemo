package com.pt.core.state.manual.generic.update

interface UpdateGenericStateHandler<State> {
    fun setCurrentState(state: State)
}
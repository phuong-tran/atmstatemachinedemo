package com.pt.state.navigation.state.manual.update

interface UpdateGenericState<State> {
    fun setCurrentState(state: State)
}
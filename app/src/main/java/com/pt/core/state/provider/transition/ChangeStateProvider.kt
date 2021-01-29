package com.pt.core.state.provider.transition

import com.pt.core.data.State

interface ChangeStateProvider {
    fun setNewState(state: State)
}
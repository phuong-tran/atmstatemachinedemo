package com.pt.core.state.provider

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine

interface GraphBuilderProvider {
    fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect>
}
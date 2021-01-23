package com.pt.core1.state.controller.provider.manager

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State

interface GraphBuilderProvider {
    fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect>
}
package com.pt.core1.state.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine

interface GraphBuilderProvider {
    fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect>
}
package com.pt.core1.state.controller.provider

import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.data.TransitionData
import com.pt.core1.state.controller.provider.manager.StateMachine

import java.util.concurrent.atomic.AtomicReference

interface StateManager : StateTransition, StateMachineCreator {

    fun stateMachineHolder(): AtomicReference<StateMachine<State, Event, SideEffect>>

    override fun getStateMachine(): StateMachine<State, Event, SideEffect> =
        stateMachineHolder().get()

    fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect>

    fun changeState(state: State) {
        getStateMachine().with {
            initialState(state)
        }.also {
            stateMachineHolder().set(it)
        }
    }

    override fun createStateMachine(
        initState: State,
    ): StateMachine<State, Event, SideEffect> {
        return StateMachine.createWithDelegate(
            provideGraphBuilder().apply {
                initialState(initState)
            }
        ) { fromState, event, toState, sideEffect ->
            onTransaction(
                TransitionData(
                    fromState = fromState,
                    event = event,
                    toState = toState,
                    sideEffect = sideEffect
                )
            )
        }
    }

    override fun createStateMachineThenSetToHolder(initState: State) {
        stateMachineHolder().set(createStateMachine(initState))
    }

    override fun createStateMachineDefaultState(): StateMachine<State, Event, SideEffect> {
        return createStateMachine(defaultState())
    }

    override fun createStateMachineDefaultStateThenSetToHolder() {
        stateMachineHolder().set(createStateMachineDefaultState())
    }
}
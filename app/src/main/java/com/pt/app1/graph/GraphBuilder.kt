package com.pt.app1.graph

import com.pt.app1.graph.event.Events
import com.pt.app1.graph.sideeffect.SideEffects
import com.pt.app1.graph.state.States
import com.pt.core1.data.Event
import com.pt.core1.data.SideEffect
import com.pt.core1.data.State
import com.pt.core1.state.manager.StateMachine

fun provideGraph(withState: State? = null): StateMachine.GraphBuilder<State, Event, SideEffect> {
    return StateMachine.GraphBuilder<State, Event, SideEffect>().apply {
        withState?.let {
            initialState(it)
        }
        state<States.IDLE> {
            on<Events.InsertCard> {
                transitionTo(States.VerifyCart)
            }

            on<Events.EjectCart> {
                dontTransition(SideEffects.Introduce)
            }
        }

        state<States.VerifyCart> {
            on<Events.VerifyCartSuccess> {
                transitionTo(States.InputPin)
            }

            on<Events.VerifyCartFailure> {
                transitionTo(States.IDLE, SideEffects.VerifyCardFailure)
            }
        }

        state<States.InputPin> {

        }
    }

}
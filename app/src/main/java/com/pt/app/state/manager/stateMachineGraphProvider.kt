package com.pt.app.state.manager

import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.sideeffect.SideEffects
import com.pt.app.state.manager.state.States
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.manager.StateMachine

fun provideGraph(): StateMachine.GraphBuilder<State, Event, SideEffect> {
    return StateMachine.GraphBuilder<State, Event, SideEffect>().apply {
       initialState(States.IDLE)
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


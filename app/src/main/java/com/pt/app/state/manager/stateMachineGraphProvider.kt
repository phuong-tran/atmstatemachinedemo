package com.pt.app.state.manager

import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.sideeffect.SideEffects
import com.pt.app.state.manager.state.States
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State
import com.pt.state.manager.StateMachine

fun provideGraph(): StateMachine.GraphBuilder<State, Event, SideEffect> {
     return StateMachine.GraphBuilder<State, Event, SideEffect>().apply {
        initialState(States.IDLE.get())
        state<States.IDLE> {
            on<Events.InsertCard> {
                transitionTo(States.VerifyCart.get())
            }

            on<Events.EjectCart> {
                dontTransition(SideEffects.Introduce.get())
            }
        }

        state<States.VerifyCart> {
            on<Events.VerifyCartSuccess> {
                transitionTo(States.InputPin.get())
            }

            on<Events.VerifyCartFailure> {
                transitionTo(States.IDLE.get(), SideEffects.VerifyCardFailure.get())
            }
        }

        state<States.InputPin> {

        }
    }

}


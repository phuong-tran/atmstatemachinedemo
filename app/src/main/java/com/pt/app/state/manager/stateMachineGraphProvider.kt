package com.pt.app.state.manager

import com.pt.app.state.manager.event.Events
import com.pt.app.state.manager.sideeffect.SideEffects
import com.pt.app.state.manager.state.States
import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State

import com.pt.state.data.transition.TransitionData
import com.pt.state.manager.StateMachine
import com.pt.state.toTransitionData

inline fun stateMachineProvider(crossinline doTransition: (transitionData: TransitionData) -> Unit): StateMachine<State, Event, SideEffect> =
    StateMachine.create {
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

        onTransition {
            val validTransition = it as? StateMachine.Transition.Valid ?: return@onTransition
            doTransition(validTransition.toTransitionData())
        }
    }


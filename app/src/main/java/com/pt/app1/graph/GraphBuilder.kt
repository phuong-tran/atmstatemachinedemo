package com.pt.app1.graph

import com.pt.app1.graph.event.Events
import com.pt.app1.graph.sideeffect.SideEffects
import com.pt.app1.graph.state.States
import com.pt.core1.data.State
import com.pt.core1.state.helper.buildGraph

fun provideGraph(withState: State? = null) = buildGraph(withState) {
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

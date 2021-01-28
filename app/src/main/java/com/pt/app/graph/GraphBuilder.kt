package com.pt.app.graph

import com.pt.app.graph.event.Events
import com.pt.app.graph.sideeffect.SideEffects
import com.pt.app.graph.state.States
import com.pt.core.data.State
import com.pt.core.state.helper.buildGraph

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

        on<Events.EjectCart> {
            transitionTo(States.IDLE)
        }
    }

    state<States.InputPin> {

    }
}

package com.pt.app.fragment.login

import com.pt.app.Model
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.helper.buildGraph
import kotlinx.android.parcel.Parcelize

class MyAccount {
    class States {

        @Parcelize
        object DefaultState : State() {
            override fun toString(): String {
                return "State Default"
            }
        }

        @Parcelize
        object LoginState : State() {
            override fun toString(): String {
                return "State LoginState"
            }
        }
    }

    class Events {
        @Parcelize
        object LoginEvent : Event() {
            override fun toString(): String {
                return "Event LoginEvent"
            }
        }

        @Parcelize
        object MyOrderEvent : Event() {
            override fun toString(): String {
                return "Event MyOrderEvent"
            }
        }

        @Parcelize
        object LoginSuccess : Event() {
            override fun toString(): String {
                return "Event LoginSuccess"
            }
        }

        @Parcelize
        object LoginSuccessGoToMyOrder : Event() {
            override fun toString(): String {
                return "Event LoginSuccessGoToMyOrder"
            }
        }
    }

    class SideEffects {
        @Parcelize
        object MyOrderSideEffect : SideEffect() {
            override fun toString(): String {
                return "SideEffect MyOrderSideEffect"
            }
        }

        @Parcelize
        object LoginSuccessSideEffect : SideEffect() {
            override fun toString(): String {
                return "SideEffect LoginSuccessSideEffect"
            }
        }

        @Parcelize
        object TriggerLogin : SideEffect() {
            override fun toString(): String {
                return "SideEffect TriggerLogin"
            }
        }
    }

    companion object {
        fun createGraph(initState: State) = buildGraph(initState) {
            state<States.DefaultState> {
                on<Events.LoginEvent> {
                    transitionTo(States.LoginState, SideEffects.TriggerLogin)
                }

                on<Events.MyOrderEvent> {
                    if (Model.isLogin) {
                        dontTransition(SideEffects.MyOrderSideEffect)
                    } else {
                        transitionTo(States.LoginState, SideEffects.MyOrderSideEffect)
                    }
                }
            }

            state<States.LoginState> {
                on<Events.LoginSuccessGoToMyOrder> {
                    transitionTo(States.DefaultState, SideEffects.MyOrderSideEffect)
                }

                on<Events.LoginSuccess> {
                    transitionTo(States.DefaultState, SideEffects.LoginSuccessSideEffect)
                }
            }
        }
    }
}
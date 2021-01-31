package com.pt.app.fragment.myaccount


import android.os.Bundle
import android.util.Log
import android.view.View
import com.pt.app.Model
import com.pt.app.fragment.MyOrdersFragment
import com.pt.app.fragment.login.LoginFragment
import com.pt.app.fragment.login.MyAccount
import com.pt.backstackcontroller.navigation.MultiStackNavigator
import com.pt.backstackcontroller.navigation.activityNavigatorController
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateChangeableFragmentController
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.MyAccountLayoutBinding

class MyAccountFragment :
    StandAloneStateChangeableFragmentController(R.layout.my_account_layout) {
    var tabIndex: Int by fragmentArgs()
    override val TAG = "MyAccountFragment"

    private val navigator by activityNavigatorController<MultiStackNavigator>()

    lateinit var binding: MyAccountLayoutBinding
    private fun updateButtons() {
        with(binding) {
            if (Model.isLogin) {
                logoutButton.visibility = View.VISIBLE
                loginButton.visibility = View.GONE
            } else {
                logoutButton.visibility = View.GONE
                loginButton.visibility = View.VISIBLE
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MyAccountLayoutBinding.bind(view)
        updateButtons()
        with(binding) {
            logoutButton.setOnClickListener {
                Model.isLogin = false
                updateButtons()
            }
            loginButton.setOnClickListener {
                stateContext.transition(MyAccount.Events.LoginEvent)
            }

            myOrdersButton.setOnClickListener {
                stateContext.transition(MyAccount.Events.MyOrderEvent)
            }
        }
    }

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        return MyAccount.createGraph(MyAccount.States.DefaultState)
    }


    override fun onTransaction(transitionData: TransitionData) {
        with(transitionData) {
            when (currentState) {
                is MyAccount.States.DefaultState -> {
                    when (sideEffect) {
                        is MyAccount.SideEffects.MyOrderSideEffect -> {
                            navigator.push(MyOrdersFragment.newInstance())
                        }
                        is MyAccount.SideEffects.LoginSuccessSideEffect -> {
                            navigator.pop()
                        }
                        else -> {

                        }
                    }

                }
                is MyAccount.States.LoginState -> {
                    (sideEffect as? MyAccount.SideEffects.TriggerLogin)?.let {
                        navigator.push(LoginFragment.newInstance(stateContext))
                    }

                    (sideEffect as? MyAccount.SideEffects.MyOrderSideEffect)?.let {
                        navigator.push(LoginFragment.newInstance(stateContext))
                    }
                }

                else -> {
                }
            }
        }
    }

    override fun provideDefaultState(): State = MyAccount.States.DefaultState


    companion object {
        fun newInstance(tabIndex: Int) = MyAccountFragment().apply {
            this.tabIndex = tabIndex
        }
    }
}
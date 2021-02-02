package com.pt.app.fragment.myaccount

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pt.app.fragment.MyOrdersFragment
import com.pt.app.fragment.login.LoginFragment
import com.pt.app.fragment.login.MyAccount
import com.pt.backstackcontroller.navigation.MultiStackNavigator
import com.pt.backstackcontroller.navigation.activityNavigatorController
import com.pt.backstackcontroller.navigation.childStackNavigationController
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs
import com.pt.backstackcontroller.navigation.extensions.addOnBackPressedCallback
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R
import com.pt.helper.fragment.FragmentAnim

class MyAccountFragmentHolder :
    StandAloneStateRecoverableFragmentController(R.layout.fragment_holder_layout) {
    var tabIndex: Int by fragmentArgs()

    override val TAG = "MyAccountFragment"

    private val activityNavigator by activityNavigatorController<MultiStackNavigator>()
    private val stackNavigator by childStackNavigationController(R.id.fragmentHolder)


    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        return MyAccount.createGraph(MyAccount.States.DefaultState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addOnBackPressedCallback {
            isEnabled =
                if (activityNavigator.current !== this@MyAccountFragmentHolder) {
                    false
                } else {
                    stackNavigator.pop()
                }
            if (!isEnabled) activity?.onBackPressed()
        }
    }


    override fun onTransaction(transitionData: TransitionData) {
        with(transitionData) {
            when (currentState) {
                is MyAccount.States.DefaultState -> {
                    when (sideEffect) {
                        is MyAccount.SideEffects.MyOrderSideEffect -> {
                            stackNavigator.pop()
                            addTosStack(MyOrdersFragment.newInstance())
                        }
                        is MyAccount.SideEffects.LoginSuccessSideEffect -> {
                            stackNavigator.pop()
                        }
                        else -> {
                        }
                    }
                }
                is MyAccount.States.LoginState -> {
                    (sideEffect as? MyAccount.SideEffects.TriggerLogin)?.let {
                        addTosStack(LoginFragment.newInstance())
                    }

                    (sideEffect as? MyAccount.SideEffects.MyOrderSideEffect)?.let {
                        addTosStack(LoginFragment.newInstance())
                    }
                }

                else -> {
                }
            }
        }
    }

    override fun provideDefaultState(): State = MyAccount.States.DefaultState

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        stackNavigator.apply {
            if (current == null) {
                addTosStack(MyAccountFragment.newInstance(1, "MyAccountFragment"), null)
            }
        }
    }

    private fun addTosStack(
        fragment: Fragment,
        anim: FragmentAnim? = FragmentAnim.PopSlideLeftRightAnim
    ) {
        stackNavigator.push(fragment, anim)
    }

}
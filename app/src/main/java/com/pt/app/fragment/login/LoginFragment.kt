package com.pt.app.fragment.login

import android.os.Bundle
import android.view.View
import com.pt.app.Model
import com.pt.core.controller.fragment.contextbase.recoverable.parentfragmentcontext.StateRecoverableParentFragmentContextController
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.LoginLayoutBinding

class LoginFragment : StateRecoverableParentFragmentContextController(R.layout.login_layout) {
    override val TAG = "LoginFragment"
    lateinit var binding: LoginLayoutBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginLayoutBinding.bind(view)

        with(binding) {
            loginButton.setOnClickListener {
                Model.isLogin = true
                stateContext?.let {
                    with(it.getCurrentTransitionData()) {
                        when (sideEffect) {
                            is MyAccount.SideEffects.MyOrderSideEffect -> {
                                it.transition(MyAccount.Events.LoginSuccessGoToMyOrder)
                            }
                            else -> {
                                it.transition(MyAccount.Events.LoginSuccess)
                            }
                        }
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        // In case of canceling by user we should set state to previous state
        // It makes sense
        stateContext?.apply {
            setCurrentState(getCurrentTransitionData().fromState)
        }
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
package com.pt.app.fragment.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.pt.app.Model
import com.pt.core.state.provider.template.changeable.StateContextChangeableProvider
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.LoginLayoutBinding

class LoginFragment(
    private val stateContext: StateContextChangeableProvider
) : Fragment(R.layout.login_layout) {
    lateinit var binding: LoginLayoutBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoginLayoutBinding.bind(view)

        with(binding) {
            loginButton.setOnClickListener {
                Model.isLogin = true

                with(stateContext.getCurrentTransitionData()) {
                  when(sideEffect) {
                      is MyAccount.SideEffects.MyOrderSideEffect -> {
                          stateContext.transition(MyAccount.Events.LoginSuccessGoToMyOrder)
                      }
                      else -> {
                          stateContext.transition(MyAccount.Events.LoginSuccess)
                      }
                  }
                }
            }
        }
    }

    companion object {
        fun newInstance(
            stateContext: StateContextChangeableProvider
        ) = LoginFragment(stateContext)
    }
}
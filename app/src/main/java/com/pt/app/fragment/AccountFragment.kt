package com.pt.app.fragment


import android.os.Bundle
import android.view.View
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateChangeableFragmentController
import com.pt.core.controller.fragment.standalone.withoutviewmodel.StandAloneStateRecoverableFragmentController
import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.manager.StateMachine
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.AccountLayoutBinding

class AccountFragment : StandAloneStateChangeableFragmentController(R.layout.account_layout) {
    var tabIndex: Int by fragmentArgs()
    override val TAG = "AccountFragment"

    override fun provideGraphBuilder(): StateMachine.GraphBuilder<State, Event, SideEffect> {
        TODO("Not yet implemented")
    }

    override fun onTransaction(transitionData: TransitionData) {
        TODO("Not yet implemented")
    }

    override fun provideDefaultState(): State {
        TODO("Not yet implemented")
    }

    lateinit var binding: AccountLayoutBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = AccountLayoutBinding.bind(view)
        with(binding) {
            if (isLogin) {
                loginButton.visibility = View.GONE
                logoutButton.visibility = View.VISIBLE
            } else {
                loginButton.visibility = View.VISIBLE
                logoutButton.visibility = View.GONE
            }

            btnMyOrders.setOnClickListener {
                if (isLogin) {

                }
            }
        }

    }
    companion object {
        var isLogin = false
    }
}

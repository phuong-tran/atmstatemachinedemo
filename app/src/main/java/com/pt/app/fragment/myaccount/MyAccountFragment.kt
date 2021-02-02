package com.pt.app.fragment.myaccount


import android.os.Bundle
import android.view.View
import com.pt.app.Model
import com.pt.app.fragment.login.MyAccount
import com.pt.backstackcontroller.navigation.Navigator
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs
import com.pt.core.controller.fragment.contextbase.recoverable.parentfragmentcontext.StateRecoverableParentFragmentContextController
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.MyAccountLayoutBinding

class MyAccountFragment :
    StateRecoverableParentFragmentContextController(R.layout.my_account_layout),
    Navigator.TagProvider {

    var tabIndex: Int by fragmentArgs()
    var fragmentID: String by fragmentArgs()

    override val stableTag: String
        get() = "${javaClass.simpleName}-$TAG-$fragmentID"

    override val TAG = "MyAccountFragment"

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
                stateContext?.transition(MyAccount.Events.LoginEvent)
            }

            myOrdersButton.setOnClickListener {
                stateContext?.transition(MyAccount.Events.MyOrderEvent)
            }
        }
    }

    companion object {
        fun newInstance(tabIndex: Int, fragmentID: String) = MyAccountFragment().apply {
            this.tabIndex = tabIndex
            this.fragmentID = fragmentID
        }
    }
}
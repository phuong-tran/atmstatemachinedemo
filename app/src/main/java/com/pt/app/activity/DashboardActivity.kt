package com.pt.app.activity

import android.os.Bundle
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import com.pt.app.fragment.factory.getMainFragmentForTab
import com.pt.backstackcontroller.navigation.MultiStackNavigator
import com.pt.backstackcontroller.navigation.Navigator
import com.pt.backstackcontroller.navigation.delegate.activityIntent
import com.pt.backstackcontroller.navigation.multiStackNavigationController
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.DashBoardLayoutBinding
import com.pt.helper.fragment.FragmentAnim

class DashboardActivity : AppCompatActivity(), Navigator.Controller {
    private val deepLinkTab by activityIntent<Int?>(-1)
    private val tabs =
        intArrayOf(R.id.mn_home, R.id.mn_category, R.id.mn_bag, R.id.mn_wishlist, R.id.mn_account)

    private val binding by lazy { DashBoardLayoutBinding.inflate(layoutInflater) }

    override val navigator: MultiStackNavigator by multiStackNavigationController(
        tabs.size,
        R.id.viewHolder,
        rootFunction = ::getMainFragmentForTab
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        onBackPressedDispatcher.addCallback(this) { if (!navigator.pop()) finish() }
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.navView.apply {
            navigator.stackSelectedListener = { menu.findItem(tabs[it])?.isChecked = true }
            setOnNavigationItemSelectedListener {
                navigator.show(tabs.indexOf(it.itemId)).let { true }
            }
            setOnNavigationItemReselectedListener { navigator.activeNavigator.clear() }
        }


        binding.navView.apply {
            navigator.stackSelectedListener = { menu.findItem(tabs[it])?.isChecked = true }
            //navigator.stackTransactionModifier = navigator.materialFadeThroughTransition()
            //navigator.transactionModifier = navigator.materialDepthAxisTransition()

            // Swallow insets, don't allow default behavior
            //setOnApplyWindowInsetsListener { _: View?, windowInsets: WindowInsets? -> windowInsets }
            setOnNavigationItemSelectedListener { navigator.show(tabs.indexOf(it.itemId), FragmentAnim.PopSlideLeftRightAnim).let { true } }
            setOnNavigationItemReselectedListener { navigator.activeNavigator.clear() }
        }
    }
}
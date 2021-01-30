package com.pt.app.fragment

import android.util.Log
import androidx.fragment.app.Fragment
import com.pt.backstackcontroller.navigation.MultiStackNavigator
import com.pt.backstackcontroller.navigation.activityNavigatorController
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs
import com.pt.dig.atm.R

class RouteFragment : Fragment(R.layout.intro_layout) {
    private var tabIndex: Int by fragmentArgs()
    private val navigator by activityNavigatorController<MultiStackNavigator>()

    companion object {
        fun newInstance(tabIndex: Int): RouteFragment =
            RouteFragment().apply { this.tabIndex = tabIndex }.also {
                Log.d("PHUONGTRAN", "${it.tabIndex}")
            }
    }
}

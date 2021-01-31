package com.pt.app.fragment

import com.pt.app.fragment.base.BaseRouteFragment
import com.pt.dig.atm.R

class MyOrdersFragment() : BaseRouteFragment(R.layout.my_orders_layout) {
    companion object {
        fun newInstance() = MyOrdersFragment()
    }
}
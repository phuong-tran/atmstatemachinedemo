package com.pt.app.fragment

import com.pt.app.fragment.base.BaseRouteFragment
import com.pt.dig.atm.R

class ProductListFragment : BaseRouteFragment(R.layout.product_list_layout) {
    companion object {
        fun newInstance() = ProductListFragment()
    }
}
package com.pt.app.fragment.factory

import androidx.fragment.app.Fragment
import com.pt.app.fragment.*
import java.lang.IllegalStateException

fun getMainFragmentForTab(tabIndex: Int): Fragment {
    return when (tabIndex) {
        0 -> HomeFragment().apply {
            this.tabIndex = tabIndex
        }
        1 -> MainCategoryFragment().apply {
            this.tabIndex = tabIndex
        }
        2 -> BagFragment().apply {
            this.tabIndex = tabIndex
        }
        3 -> WhistListFragment().apply {
            this.tabIndex = tabIndex
        }

        4 -> AccountFragment().apply {
            this.tabIndex = tabIndex
        }
        else -> throw IllegalStateException("IllegalStateException")
    }
}
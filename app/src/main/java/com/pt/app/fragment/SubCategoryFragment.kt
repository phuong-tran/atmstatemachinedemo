package com.pt.app.fragment

import android.os.Bundle
import android.view.View
import com.pt.app.fragment.base.BaseRouteFragment
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.SubCategoryLayoutBinding


class SubCategoryFragment : BaseRouteFragment(R.layout.sub_category_layout) {
    lateinit var binding: SubCategoryLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SubCategoryLayoutBinding.bind(view)

        with(binding) {
            dressesButton.setOnClickListener {
                navigator.push(ProductListFragment.newInstance())
            }
            skirtButton.setOnClickListener {
                navigator.push(ProductListFragment.newInstance())
            }
        }
    }

    companion object {
        fun newInstance() = SubCategoryFragment()
    }
}
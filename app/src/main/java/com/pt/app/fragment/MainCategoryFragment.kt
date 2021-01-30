package com.pt.app.fragment

import android.os.Bundle
import android.view.View
import com.pt.app.fragment.base.BaseRouteFragment
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.MainCategoryLayoutBinding

class MainCategoryFragment: BaseRouteFragment(R.layout.main_category_layout) {

    lateinit var binding: MainCategoryLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainCategoryLayoutBinding.bind(view)
        with(binding) {
            clothingButton.setOnClickListener {
                navigator.push(SubCategoryFragment.newInstance())
            }

            shoesButton.setOnClickListener {
                navigator.push(SubCategoryFragment.newInstance())
            }
        }
    }
}
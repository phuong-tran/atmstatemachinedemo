package com.pt.app.fragment

import android.os.Bundle
import android.view.View
import com.pt.app.fragment.base.BaseRouteFragment
import com.pt.dig.atm.R
import com.pt.dig.atm.databinding.MainCategoryLayoutBinding
import com.pt.helper.fragment.FragmentAnim

class MainCategoryFragment: BaseRouteFragment(R.layout.main_category_layout) {

    private lateinit var binding: MainCategoryLayoutBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = MainCategoryLayoutBinding.bind(view)
        with(binding) {
            clothingButton.setOnClickListener {
                navigator.push(SubCategoryFragment.newInstance(), FragmentAnim.PopSlideLeftRightAnim)
            }

            shoesButton.setOnClickListener {
                navigator.push(SubCategoryFragment.newInstance(), FragmentAnim.PopSlideLeftRightAnim)
            }
        }
    }
}
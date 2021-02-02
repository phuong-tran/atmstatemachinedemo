package com.pt.helper.fragment

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.FragmentTransaction
import com.pt.dig.atm.R

data class FragmentAnim(
    @AnimatorRes @AnimRes val enter: Int = 0,
    @AnimatorRes @AnimRes val exit: Int = 0,
    @AnimatorRes @AnimRes val popEnter: Int = 0,
    @AnimatorRes @AnimRes val popExit: Int = 0,
) {


    companion object {
        val PopSlideLeftRightAnim: FragmentAnim by lazy {
            FragmentAnim(
                popEnter = R.anim.slide_in_left,
                popExit = R.anim.slide_out_right,
            )
        }

        val ThemeEnterPopSlideLeftRightAnim: FragmentAnim by lazy {
            FragmentAnim(
                enter = R.anim.slide_in_right,
                exit = R.anim.slide_out_left,
                popEnter = R.anim.slide_in_left,
                popExit = R.anim.slide_out_right,
            )
        }

        val MainEnterPopSlideLeftRightAnim: FragmentAnim by lazy {
            FragmentAnim(
                enter = R.anim.slide_in_left,
                exit = R.anim.slide_out_right,
                popEnter = R.anim.slide_in_left,
                popExit = R.anim.slide_out_right
            )
        }

        val defaultFragmentAnim: FragmentAnim by lazy {
            FragmentAnim(
                enter = R.anim.slide_in_right,
                exit = R.anim.slide_out_left,
                popEnter = R.anim.slide_in_left,
                popExit = R.anim.slide_out_right,
            )
        }

        fun createStartFragmentAnimation(animation: Boolean): FragmentAnim {
            return if (animation) {
                defaultFragmentAnim
            } else {
                PopSlideLeftRightAnim
            }
        }
    }
}

fun FragmentTransaction.setFragmentAnimation(anim: FragmentAnim?) {
    anim?.let {
        this.setCustomAnimations(it.enter, it.exit, it.popEnter, it.popExit)
    }
}
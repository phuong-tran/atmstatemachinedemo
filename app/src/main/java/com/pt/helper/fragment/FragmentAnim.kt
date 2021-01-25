package com.pt.helper.fragment

import androidx.annotation.AnimRes
import androidx.annotation.AnimatorRes

data class FragmentAnim(
    @AnimatorRes @AnimRes val enter: Int = 0,
    @AnimatorRes @AnimRes val exit: Int = 0,
    @AnimatorRes @AnimRes val popEnter: Int = 0,
    @AnimatorRes @AnimRes val popExit: Int = 0,
)
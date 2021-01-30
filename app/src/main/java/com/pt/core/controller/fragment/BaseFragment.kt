package com.pt.core.controller.fragment

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment(@LayoutRes layoutId: Int = 0) : Fragment(layoutId) {
    protected abstract val TAG: String
}
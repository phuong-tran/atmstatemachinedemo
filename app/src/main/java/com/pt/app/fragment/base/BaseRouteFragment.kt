package com.pt.app.fragment.base

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.pt.backstackcontroller.navigation.MultiStackNavigator
import com.pt.backstackcontroller.navigation.activityNavigatorController
import com.pt.backstackcontroller.navigation.delegate.fragmentArgs

abstract class BaseRouteFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    var tabIndex: Int by fragmentArgs()
    protected val navigator by activityNavigatorController<MultiStackNavigator>()
}
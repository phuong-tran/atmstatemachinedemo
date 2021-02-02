package com.pt.helper.fragment.helper

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.pt.helper.fragment.FragmentAnim

enum class FragmentFlag {
    ADD,
    REPLACE,

}

private fun FragmentManager.createAddOrReplaceFragmentTransaction(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAdd: Boolean = true,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
): FragmentTransaction {
    popBackStackImmediate()
    TODO()
}

/*
fun FragmentManager.withTransaction(
    @IdRes containerViewId: Int,
    fragmentTag: String? = null,
    backStackName: String? = null,
    body: FragmentTransaction.() -> Unit
) {
    val transaction = beginTransaction()
    transaction.body()

}*/

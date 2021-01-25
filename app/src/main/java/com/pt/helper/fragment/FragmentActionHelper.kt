package com.pt.helper.fragment

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

private const val TAG = "FragmentActionHelper"

private fun FragmentManager.createAddOrReplaceFragmentTransaction(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAdd: Boolean = true,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
): FragmentTransaction {
    return beginTransaction().apply {
        if (isAdd) {
            add(containerViewId, fragment, fragmentTag)
        } else {
            replace(containerViewId, fragment, fragmentTag)
        }
        if (isAddToBackStack && isAddToBackStackAllowed) {
            addToBackStack(stackName)
        }
        animation?.apply {
            setCustomAnimations(enter, exit, popEnter, popExit)
        }
    }
}

fun FragmentManager.addThenCommit(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        true,
        isAddToBackStack,
        stackName,
        animation,
    ).commit()
}

fun FragmentManager.addThenCommitNow(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        true,
        isAddToBackStack,
        stackName,
        animation,
    ).commitNow()
}

fun FragmentManager.addThenCommitAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        true,
        isAddToBackStack,
        stackName,
        animation,
    ).commitAllowingStateLoss()
}

fun FragmentManager.addThenCommitNowAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        true,
        isAddToBackStack,
        stackName,
        animation,
    ).commitNowAllowingStateLoss()
}


fun FragmentManager.replaceThenCommit(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        false,
        isAddToBackStack,
        stackName
    ).commit()
}

fun FragmentManager.replaceThenCommitNow(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        tag,
        false,
        isAddToBackStack,
        stackName,
        animation,
    ).commitNow()
}

fun FragmentManager.replaceThenCommitAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        false,
        isAddToBackStack,
        stackName,
        animation,
    ).commitAllowingStateLoss()
}

fun FragmentManager.replaceThenCommitNowAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    fragmentTag: String? = null,
    isAddToBackStack: Boolean = true,
    stackName: String? = null,
    animation: FragmentAnim? = null,
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        fragmentTag,
        false,
        isAddToBackStack,
        stackName,
        animation,
    ).commitNowAllowingStateLoss()
}
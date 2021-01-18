package com.pt.app.fragment.helper

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


private const val TAG = "FragmentActionHelper"

private fun FragmentManager.createAddOrReplaceFragmentTransaction(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null,
    isAdd: Boolean = true
): FragmentTransaction {
    return beginTransaction().apply {
        if (isAdd) {
            add(containerViewId, fragment, tag)
        } else {
            replace(containerViewId, fragment, tag)
        }
    }
}

fun FragmentManager.addThenCommit(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(containerViewId, fragment, tag).commit()
}

fun FragmentManager.addThenCommitNow(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(containerViewId, fragment, tag).commitNow()
}

fun FragmentManager.addThenCommitAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(containerViewId, fragment, tag).commitAllowingStateLoss()
}

fun FragmentManager.addThenCommitNowAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        tag
    ).commitNowAllowingStateLoss()
}


fun FragmentManager.replaceThenCommit(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(containerViewId, fragment, tag, false).commit()
}

fun FragmentManager.replaceThenCommitNow(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(containerViewId, fragment, tag, false).commitNow()
}

fun FragmentManager.replaceThenCommitAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        tag,
        false
    ).commitAllowingStateLoss()
}

fun FragmentManager.replaceThenCommitNowAllowingStateLoss(
    @IdRes containerViewId: Int,
    fragment: Fragment,
    tag: String? = null
) {
    createAddOrReplaceFragmentTransaction(
        containerViewId,
        fragment,
        tag,
        false
    ).commitNowAllowingStateLoss()
}
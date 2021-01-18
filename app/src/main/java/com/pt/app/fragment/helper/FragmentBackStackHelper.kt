package com.pt.app.fragment.helper

import android.util.Log
import androidx.fragment.app.FragmentManager

private const val TAG = "FragmentBackStackHelper"

private fun FragmentManager.clearBackStackByName(
    givenName: String? = null,
    isPopBackStackImmediate: Boolean = false
) {
    try {
        if (backStackEntryCount > 0) {
            val name = givenName ?: getBackStackEntryAt(0).name
            if (isPopBackStackImmediate) {
                popBackStackImmediate(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            } else {
                popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    } catch (e: Exception) {
        Log.e(TAG, "clearBackStackByName isPopBackStackImmediate = $isPopBackStackImmediate $e")
    }
}

private fun FragmentManager.clearBackStackByEntryId(isPopBackStackImmediate: Boolean = false) {
    try {
        if (backStackEntryCount > 0) {
            val entry: FragmentManager.BackStackEntry = getBackStackEntryAt(0)
            if (isPopBackStackImmediate) {
                popBackStackImmediate(entry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            } else {
                popBackStack(entry.id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    } catch (e: Exception) {
        Log.e(TAG, "clearBackStackByEntryId isPopBackStackImmediate = $isPopBackStackImmediate $e")
    }
}

private fun FragmentManager.clearFragmentByTag(
    tag: String,
    isPopBackStackImmediate: Boolean = false
) {
    try {
        for (i in backStackEntryCount - 1 downTo 0) {
            val backEntry = getBackStackEntryAt(i).name
            if (backEntry == tag) {
                break
            } else {
                if (isPopBackStackImmediate) {
                    popBackStackImmediate()
                } else {
                    popBackStack()
                }
            }
        }
    } catch (e: Exception) {
        Log.e(TAG, "clearFragmentByTag isPopBackStackImmediate = $isPopBackStackImmediate $e")
    }
}

fun FragmentManager.clearBackStackByName(name: String? = null) {
    clearBackStackByName(givenName = name, isPopBackStackImmediate = false)
}

fun FragmentManager.clearBackStackImmediateByName(name: String? = null) {
    clearBackStackByName(givenName = name, isPopBackStackImmediate = true)
}

private fun FragmentManager.clearBackStackByEntryId() {
    clearBackStackByEntryId(isPopBackStackImmediate = false)
}

private fun FragmentManager.clearBackStackImmediateByEntryId() {
    clearBackStackByEntryId(isPopBackStackImmediate = true)
}


private fun FragmentManager.clearFragmentByTag(tag: String) {
    clearFragmentByTag(tag = tag, isPopBackStackImmediate = false)
}

private fun FragmentManager.clearFragmentImmediateByTag(tag: String) {
    clearFragmentByTag(tag = tag, isPopBackStackImmediate = true)
}

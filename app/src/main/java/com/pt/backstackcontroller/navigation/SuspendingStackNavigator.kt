package com.pt.backstackcontroller.navigation

import androidx.fragment.app.Fragment
import androidx.lifecycle.whenResumed

class SuspendingStackNavigator internal constructor(
    private val navigator: StackNavigator
) : SuspendingNavigator by CommonSuspendingNavigator(navigator) {

    override suspend fun clear(upToTag: String?, includeMatch: Boolean): Fragment? {
        val tag = upToTag ?: navigator.fragmentTags.firstOrNull() ?: ""
        val index = navigator.fragmentTags.indexOf(tag).let { if (includeMatch) it - 1 else it }
        val toShow = if (index < 0) null else navigator.find(navigator.fragmentTags[index] ?: "")

        navigator.clear(upToTag, includeMatch)
        toShow?.whenResumed(doNothing)

        return toShow
    }
}
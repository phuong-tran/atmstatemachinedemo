package com.pt.backstackcontroller.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.pt.backstackcontroller.navigation.extensions.navigatorTag
import com.pt.helper.fragment.FragmentAnim
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

/**
 * Convenience method for [Fragment] delegation to a [FragmentActivity] when implementing
 * [Navigator.Controller]
 */
inline fun <reified T : Navigator> Fragment.activityNavigatorController() = object : ReadOnlyProperty<Fragment, T> {
    override operator fun getValue(thisRef: Fragment, property: KProperty<*>): T =
            (activity as? Navigator.Controller)?.navigator as? T
                    ?: throw IllegalStateException("The hosting Activity is not a Navigator Controller")
}

/**
 * Provides a window into the Navigator. This type is returned when the [Navigator] is not
 * guaranteed to be attached, and it is therefore unsafe to perform any mutating calls with it.
 */
interface ReadOnlyNavigator {
    /**
     * The id of the container this [Navigator] shows [Fragment]s in
     */
    @get:IdRes
    val containerId: Int

    /**
     * The current visible [Fragment] the User can interact with
     */
    val current: Fragment?

    /**
     * The [Fragment] that will become the [current] following a [Navigator.pop]
     */
    val previous: Fragment?

    /**
     * Finds a [Fragment] that has previously been shown with this [Navigator]
     */
    fun find(tag: String): Fragment?
}

/**
 * An interface for managing and showing [Fragment] instances
 */
interface Navigator : ReadOnlyNavigator {

    /**
     * Pops the current fragment off the stack, up until the last fragment.
     *
     * @return true if a fragment was popped, false if the stack is down to the last fragment.
     */
    fun pop(): Boolean

    /**
     * Pops the stack up to the [upToTag] value. If null is passed as the value,
     * the stack will be popped to the root [Fragment].
     * By default it doesn't pop the Fragment matching the [upToTag]; to do so, pass true for the
     * [includeMatch] parameter.
     */
    fun clear(upToTag: String? = null, includeMatch: Boolean = false)

    /**
     * Attempts to show the fragment provided, retrieving it from the back stack
     * if an identical instance of it already exists in the [FragmentManager] under the specified
     * tag.
     */
    fun push(fragment: Fragment, tag: String, anim: FragmentAnim?): Boolean
    fun push(fragment: Fragment, tag: String): Boolean

    /**
     * Attempts to show the fragment provided, retrieving it from the back stack
     * if an identical instance of it already exists in the [FragmentManager] under the specified
     * tag.
     *
     * This is a convenience method for showing a [Fragment] without having to explicitly provide a
     * tag
     *
     * @see push
     */
    fun push(fragment: Fragment) = push(fragment, fragment.navigatorTag)
    fun push(fragment: Fragment, anim: FragmentAnim?) = push(fragment, fragment.navigatorTag, anim)

    /**
     * An interface to provide unique tags for [Fragment]. Fragment implementers typically delegate
     * this to a hash string of their arguments.
     *
     * It's convenient to let  Fragments implement this interface, along with [TransactionModifier].
     */
    interface TagProvider {
        val stableTag: String
    }

    /**
     * An interface for augmenting the [FragmentTransaction] that will show
     * the incoming Fragment. Implementers typically configure mappings for
     * shared element transitions, or other kinds of animations.
     *
     * It's convenient to let Fragments implement this interface, along with [TagProvider].
     */
    interface TransactionModifier {
        fun augmentTransaction(transaction: FragmentTransaction, incomingFragment: Fragment)
    }

    /**
     * Interface for a class that hosts a [Navigator]
     */
    interface Controller {
        val navigator: Navigator
    }
}
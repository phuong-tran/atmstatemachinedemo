package com.pt.app.state.singleton

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class SingletonLazy<T : Any>(val initBlock: () -> T, val clazz: Class<T>) {
    operator fun <R> provideDelegate(ref: R, prop: KProperty<*>): ReadOnlyProperty<R, T> =
        delegate()

    @Suppress("UNCHECKED_CAST")
    private fun <R> delegate(): ReadOnlyProperty<R, T> = object : ReadOnlyProperty<R, T> {
        override fun getValue(thisRef: R, property: KProperty<*>): T {
            val hash = clazz.hashCode()
            val cached = singletonsCache[hash]
            if (cached != null && cached.javaClass == clazz) return cached as T
            return initBlock().apply { singletonsCache[hash] = this }
        }
    }

    companion object {
        private val singletonsCache = HashMap<Int, Any>()
        fun <T> clearSingleton(clazz: Class<T>): Boolean {
            val hash = clazz.hashCode()
            val result = singletonsCache[hash]
            if (result?.javaClass != clazz) return false
            singletonsCache.remove(hash)
            return true
        }
    }
}
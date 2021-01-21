package com.pt.app.state.singleton

import java.util.concurrent.ConcurrentHashMap
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
        private val singletonsCache = ConcurrentHashMap<Int, Any>()

        fun <T> remove(clazz: Class<T>): Boolean {
            val hash = clazz.hashCode()
            val result = singletonsCache[hash]
            if (result?.javaClass != clazz) return false
            singletonsCache.remove(hash)
            return true
        }

        fun clearAll() {
            singletonsCache.clear()
        }

        @Suppress("UNCHECKED_CAST")
        fun <T> get(clazz: Class<T>): T? {
            return singletonsCache[clazz.hashCode()] as? T
        }

        @Suppress("UNCHECKED_CAST")
        fun <T> update(clazz: Class<T>, initBlock: () -> T) {
            remove(clazz)
            val value: T = initBlock()
            val hash = clazz.hashCode()
            initBlock().apply {
                singletonsCache[hash] = value as Any
            }
        }

        fun size(): Int = singletonsCache.size

        fun getAll(): List<Any> = singletonsCache.values.toList()
    }
}
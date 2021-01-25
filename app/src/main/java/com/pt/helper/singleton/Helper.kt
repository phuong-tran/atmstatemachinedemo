package com.pt.helper.singleton

inline fun <reified T : Any> singletonLazy(noinline block: () -> T): SingletonLazy<T> =
    SingletonLazy(block, T::class.java)

inline fun <reified T : Any> updateSingleton(noinline block: () -> T) {
    SingletonLazy.update(T::class.java, block)
}

inline fun <reified T : Any> getSingleton(): T? {
    return SingletonLazy.get(T::class.java)
}

inline fun <reified T : Any> removeSingleton(): Boolean {
    return SingletonLazy.remove(T::class.java)
}
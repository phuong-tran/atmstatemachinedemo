package com.pt.app.state.singleton

inline fun <reified T> createObject(creator: () -> T) : T = creator()

inline fun <T> createObjectLazy(crossinline initializer: () -> T): Lazy<T> = lazy(LazyThreadSafetyMode.PUBLICATION) {
    initializer()
}


inline fun <reified T : Any> singletonLazy(noinline block: () -> T): SingletonLazy<T> =
    SingletonLazy(block, T::class.java)

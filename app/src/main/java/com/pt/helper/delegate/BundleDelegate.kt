package com.pt.helper.delegate
// https://proandroiddev.com/kotlin-delegation-by-inception-61f8beaae0db
// https://proandroiddev.com/kotlin-delegation-by-inception-61f8beaae0db

/*
import android.os.Bundle
import androidx.core.os.bundleOf
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class BundleDelegate<T>(
    private val default: T? = null
) : ReadWriteProperty<Bundle, T> {
    @Suppress("UNCHECKED_CAST")
    override operator fun getValue(
        thisRef: Bundle,
        property: KProperty<*>
    ): T = when (val value = thisRef.get(property.name)) {
        null -> default
        else -> value
    } as T

    override fun setValue(thisRef: Bundle, property: KProperty<*>, value: T) =
        thisRef.putAll(bundleOf(property.name to value))
}*/

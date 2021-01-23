package com.pt.core1.data

import android.os.Parcelable

sealed class SideEffect : Parcelable

// Hack
abstract class SideEffectBase : SideEffect()
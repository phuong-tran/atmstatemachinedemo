package com.pt.core.data

import android.os.Parcelable

sealed class SideEffect : Parcelable

// Hack
abstract class SideEffectBase : SideEffect()
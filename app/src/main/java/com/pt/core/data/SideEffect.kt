package com.pt.core.data

import android.os.Parcelable

sealed class SideEffectBase : Parcelable

// Hack
abstract class SideEffect : SideEffectBase()
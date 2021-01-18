package com.pt.state.data

import android.os.Parcelable

sealed class SideEffect : Parcelable

// Hack
abstract class SideEffectBase : SideEffect()
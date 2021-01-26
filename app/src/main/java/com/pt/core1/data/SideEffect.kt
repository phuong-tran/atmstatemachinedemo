package com.pt.core1.data

import android.os.Parcelable

sealed class SideEffectBase : Parcelable

// Hack
abstract class SideEffect : SideEffectBase()


/*
abstract class SideEffectBase : Parcelable

// Hack
sealed class SideEffect : SideEffectBase()*/

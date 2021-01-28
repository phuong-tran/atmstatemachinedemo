package com.pt.core.state.provider

import com.pt.core.data.State

interface DefaultStateProvider {
   fun provideDefaultState(): State
}
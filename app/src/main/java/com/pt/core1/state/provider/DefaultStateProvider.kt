package com.pt.core1.state.provider

import com.pt.core1.data.State

interface DefaultStateProvider {
   fun provideDefaultState(): State
}
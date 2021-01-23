package com.pt.core1.state.controller.provider

import com.pt.core1.data.State

interface DefaultStateProvider {
   fun defaultState(): State
}
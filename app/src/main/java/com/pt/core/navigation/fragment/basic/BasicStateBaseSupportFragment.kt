package com.pt.core.navigation.fragment.basic

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State

abstract class BasicStateBaseSupportFragment :
    BasicStateSupportGenericFragment<State, Event, SideEffect>()

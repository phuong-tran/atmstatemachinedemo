package com.pt.core.state.common.statebase

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.common.generic.StateMachineGenericProvider

interface StateMachineProvider : StateMachineGenericProvider<State, Event, SideEffect>

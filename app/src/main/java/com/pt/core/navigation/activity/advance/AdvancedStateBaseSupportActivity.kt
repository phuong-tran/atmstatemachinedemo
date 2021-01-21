package com.pt.core.navigation.activity.advance

import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State


abstract class AdvancedStateBaseSupportActivity :
    AdvancedStateSupportGenericActivity<State, Event, SideEffect>()
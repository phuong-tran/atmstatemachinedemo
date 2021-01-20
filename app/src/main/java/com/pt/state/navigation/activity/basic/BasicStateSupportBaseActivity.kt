package com.pt.state.navigation.activity.basic

import com.pt.state.data.Event
import com.pt.state.data.SideEffect
import com.pt.state.data.State

abstract class BasicStateSupportBaseActivity :
    BasicStateSupportGenericActivity<State, Event, SideEffect>() {

}
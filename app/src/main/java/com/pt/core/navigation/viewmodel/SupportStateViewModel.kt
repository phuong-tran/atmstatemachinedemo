package com.pt.core.navigation.viewmodel


import com.pt.core.data.Event
import com.pt.core.data.SideEffect
import com.pt.core.data.State
import com.pt.core.state.advance.NavigationAdvancedHandler

abstract class SupportStateViewModel(
    navigation: NavigationAdvancedHandler
) : SupportStateGenericViewModel<State, Event, SideEffect>(navigation)
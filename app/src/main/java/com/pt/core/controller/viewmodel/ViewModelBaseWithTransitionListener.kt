package com.pt.core.controller.viewmodel

import com.pt.core.state.provider.transition.StateTransactionDataProvider

abstract class ViewModelBaseWithTransitionListener: ViewModelBase(), StateTransactionDataProvider
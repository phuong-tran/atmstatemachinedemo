package com.pt.core.controller.activity

import androidx.appcompat.app.AppCompatActivity
import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.transition.StateTransactionDataProvider

abstract class StateBaseActivity : AppCompatActivity(), GraphBuilderProvider,
    StateTransactionDataProvider, DefaultStateProvider {
    protected abstract val TAG: String
}

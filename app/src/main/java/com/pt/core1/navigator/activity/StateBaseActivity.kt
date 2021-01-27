package com.pt.core1.navigator.activity

import androidx.appcompat.app.AppCompatActivity
import com.pt.core1.state.provider.DefaultStateProvider
import com.pt.core1.state.provider.GraphBuilderProvider
import com.pt.core1.state.provider.TransactionActionProvider

abstract class StateBaseActivity : AppCompatActivity(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
    protected abstract val TAG: String
}

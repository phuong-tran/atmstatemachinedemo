package com.pt.core.controller.activity

import androidx.appcompat.app.AppCompatActivity
import com.pt.core.state.provider.DefaultStateProvider
import com.pt.core.state.provider.GraphBuilderProvider
import com.pt.core.state.provider.TransactionActionProvider

abstract class StateBaseActivity : AppCompatActivity(), GraphBuilderProvider,
    TransactionActionProvider, DefaultStateProvider {
    protected abstract val TAG: String
}

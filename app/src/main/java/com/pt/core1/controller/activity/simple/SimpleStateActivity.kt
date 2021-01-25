package com.pt.core1.controller.activity.simple

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pt.core1.controller.activity.ActivityWithTag
import com.pt.core1.state.provider.IDefaultStateProvider
import com.pt.core1.state.provider.IGraphBuilderProvider
import com.pt.core1.state.provider.IStateContextProvider
import com.pt.core1.state.provider.ITransactionActionProvider
import com.pt.core1.state.helper.getStateFromBundle
import com.pt.core1.state.helper.getTransitionDataFromBundle

abstract class SimpleStateActivity : ActivityWithTag(), IGraphBuilderProvider,
    ITransactionActionProvider, IDefaultStateProvider {
    abstract val stateContext: IStateContextProvider

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(stateContext) {
            saveAllCurrentStateToBundle(outState, getCurrentState(), getCurrentTransitionData())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            with(stateContext) {
                savedInstanceState.getStateFromBundle()?.let {
                    setCurrentState(it)
                    setNewState(it)

                }
                savedInstanceState.getTransitionDataFromBundle()?.let {
                    setTransitionData(it)
                }
            }
        }
    }
}
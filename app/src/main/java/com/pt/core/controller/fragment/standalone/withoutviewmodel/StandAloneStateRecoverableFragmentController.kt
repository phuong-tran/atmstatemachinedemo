package com.pt.core.controller.fragment.standalone.withoutviewmodel

import android.os.Bundle
import androidx.annotation.LayoutRes
import com.pt.core.controller.fragment.StateBaseFragment
import com.pt.core.data.Event
import com.pt.core.data.State
import com.pt.core.data.TransitionData
import com.pt.core.state.helper.getStateFromBundle
import com.pt.core.state.helper.getTransitionDataFromBundle
import com.pt.core.state.manager.StateContextBundleStorageProviderTemplate
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

abstract class StandAloneStateRecoverableFragmentController(@LayoutRes layoutId: Int = 0) :
    StateBaseFragment(layoutId), StateContextBundleStorageProvider {
    protected val stateContext: StateContextBundleStorageProvider by lazy {
        StateContextBundleStorageProviderTemplate.create(this, this, this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        with(stateContext) {
            saveAllCurrentStateToBundle(outState, currentState = this)
        }
    }

    override fun transition(event: Event) = stateContext.transition(event)

    override fun getCurrentState(): State = stateContext.getCurrentState()

    override fun getCurrentTransitionData(): TransitionData =
        stateContext.getCurrentTransitionData()

    override fun setCurrentState(state: State) = stateContext.setCurrentState(state)

    override fun setTransitionData(transitionData: TransitionData) =
        stateContext.setTransitionData(transitionData)

    override fun setNewState(state: State) = stateContext.setNewState(state)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            with(stateContext) {
                savedInstanceState.getStateFromBundle()?.let {
                    setNewState(it)
                }

                savedInstanceState.getTransitionDataFromBundle()?.let {
                    setTransitionData(it)
                }
            }
        }
    }
}
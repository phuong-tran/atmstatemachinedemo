package com.pt.app.fragment.myaccount

import com.pt.core.controller.viewmodel.recoverable.StateRecoverableViewModelController
import com.pt.core.data.TransitionData
import com.pt.core.state.provider.template.recoverable.StateContextBundleStorageProvider

class MyAccountViewHolderModel(stateContext: StateContextBundleStorageProvider) :
    StateRecoverableViewModelController(stateContext) {
    override val TAG = "MyAccountViewHolderModel"

    override fun onTransaction(transitionData: TransitionData) {

    }
}
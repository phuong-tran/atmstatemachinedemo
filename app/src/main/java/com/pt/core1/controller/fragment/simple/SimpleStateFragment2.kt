package com.pt.core1.controller.fragment.simple

import android.content.Context
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.provider.IStateContextProvider

abstract class SimpleStateFragment2 : FragmentWithTag() {
    protected var stateContext: IStateContextProvider? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        stateContext = context as IStateContextProvider
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
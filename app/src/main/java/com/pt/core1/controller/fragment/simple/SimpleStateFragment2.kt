package com.pt.core1.controller.fragment.simple

import android.content.Context
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.provider.IStateContextProvider
import java.lang.IllegalArgumentException

abstract class SimpleStateFragment2 : FragmentWithTag() {
    var stateContext: IStateContextProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? IStateContextProvider)?.let {
            stateContext = it
        } ?: throw IllegalArgumentException("context must be implemented IStateContextProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
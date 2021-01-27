package com.pt.core1.controller.fragment.simple

import android.content.Context
import com.pt.core1.controller.fragment.FragmentWithTag
import com.pt.core1.state.provider.context.template.StateContextDefaultProvider
import java.lang.IllegalArgumentException

abstract class SimpleStateFragment2 : FragmentWithTag() {
    var stateContext: StateContextDefaultProvider? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (context as? StateContextDefaultProvider)?.let {
            stateContext = it
        } ?: throw IllegalArgumentException("context must be implemented IStateContextProvider")
    }

    override fun onDetach() {
        super.onDetach()
        stateContext = null
    }
}
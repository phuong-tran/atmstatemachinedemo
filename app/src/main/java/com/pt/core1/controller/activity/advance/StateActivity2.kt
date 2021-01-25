package com.pt.core1.controller.activity.advance

import com.pt.core1.controller.activity.simple.SimpleStateActivity2
import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportWithDelegateViewModel

abstract class StateActivity2 : SimpleStateActivity2() {
    abstract val viewModel: SimpleStateSupportWithDelegateViewModel
}
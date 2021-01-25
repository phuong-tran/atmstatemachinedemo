package com.pt.core1.controller.activity.advance

import com.pt.core1.controller.activity.simple.SimpleStateActivity
import com.pt.core1.controller.viewmodel.external.simple.SimpleStateSupportViewModel

abstract class StateActivity : SimpleStateActivity() {
    abstract val viewModel: SimpleStateSupportViewModel
}
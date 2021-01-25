package com.pt.core1.controller.activity.advance

import com.pt.core1.controller.activity.simple.SimpleStateActivity
import com.pt.core1.controller.viewmodel.external.advance.StateSupportViewModel

abstract class StateActivity3 : SimpleStateActivity() {
    protected abstract val viewModel: StateSupportViewModel
}
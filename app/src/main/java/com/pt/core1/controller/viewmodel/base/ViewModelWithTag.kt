package com.pt.core1.controller.viewmodel.base

import androidx.lifecycle.ViewModel

abstract class ViewModelWithTag: ViewModel() {
    protected abstract val TAG : String
}
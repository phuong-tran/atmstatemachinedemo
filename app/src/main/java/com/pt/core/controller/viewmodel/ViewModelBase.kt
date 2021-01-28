package com.pt.core.controller.viewmodel

import androidx.lifecycle.ViewModel

abstract class ViewModelBase : ViewModel() {
    protected abstract val TAG: String
}
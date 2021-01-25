package com.pt.core1.controller.activity

import androidx.appcompat.app.AppCompatActivity

abstract class ActivityWithTag : AppCompatActivity() {
    protected abstract val TAG: String
}
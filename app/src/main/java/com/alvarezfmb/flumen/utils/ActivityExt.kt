package com.alvarezfmb.flumen.utils

import android.app.Activity
import android.view.View


fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}
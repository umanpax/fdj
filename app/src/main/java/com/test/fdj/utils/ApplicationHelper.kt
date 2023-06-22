package com.test.fdj.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

class ApplicationHelper {
    companion object {
        fun hideKeyboard(activity: Activity) {
            val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val currentFocusedView = activity.currentFocus
            currentFocusedView?.let { view ->
                inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}
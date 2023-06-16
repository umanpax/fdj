package com.test.fdj.ui.activities.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseRegisterBinding.inflate(layoutInflater).apply {
            lifecycleOwner = lifecycleOwner
            viewModel = baseRegisterViewModel
        }
        val view = binding.root


    }

}
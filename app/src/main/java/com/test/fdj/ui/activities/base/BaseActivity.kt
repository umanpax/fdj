package com.test.fdj.ui.activities.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.test.fdj.databinding.ActivityBaseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    private val basViewModel: BaseViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater).apply {
            lifecycleOwner = lifecycleOwner
            viewModel = basViewModel
        }
        val view = binding.root
        setContentView(view)
    }
}
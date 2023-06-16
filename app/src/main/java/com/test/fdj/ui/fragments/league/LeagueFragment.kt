package com.test.fdj.ui.fragments.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.fdj.databinding.FragmentLeagueBinding
import com.test.fdj.ui.activities.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeagueFragment : Fragment() {

    private val leagueViewModel: LeagueViewModel by viewModel()
    private lateinit var binding: FragmentLeagueBinding
    private lateinit var baseActivity: BaseActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = leagueViewModel
        return binding.root
    }
}
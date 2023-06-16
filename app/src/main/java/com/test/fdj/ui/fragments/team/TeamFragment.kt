package com.test.fdj.ui.fragments.team

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.fdj.databinding.FragmentTeamBinding
import com.test.fdj.ui.activities.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment() {

    private val teamViewModel: TeamViewModel by viewModel()
    private lateinit var binding: FragmentTeamBinding
    private lateinit var baseActivity: BaseActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = teamViewModel
        return binding.root
    }
}
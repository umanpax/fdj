package com.test.fdj.ui.fragments.team

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.test.fdj.databinding.FragmentTeamBinding
import com.test.fdj.model.Team
import com.test.fdj.ui.activities.base.BaseActivity
import com.test.fdj.ui.activities.base.BaseViewModel
import com.test.fdj.usecase.NavigationState
import com.test.fdj.usecase.Result
import com.test.fdj.utils.ApplicationHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class TeamFragment : Fragment() {

    private val teamViewModel: TeamViewModel by viewModel()
    private val basViewModel: BaseViewModel by activityViewModels()
    private lateinit var binding: FragmentTeamBinding
    private lateinit var baseActivity: BaseActivity
    private lateinit var teamAdapter: TeamAdapter
    private var listTeams: List<Team> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        binding = FragmentTeamBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = teamViewModel
        }
        initUIObserver()
        initObservers()
        initSearch()
        initListener()
        return binding.root
    }

    private fun initListener(){
        binding.constraintHeader.setOnClickListener {
            ApplicationHelper.hideKeyboard(baseActivity)
        }
    }

    private fun initUIObserver() {
        teamViewModel.uiNavigationState.observe(viewLifecycleOwner) { result ->
            when (result) {
                is NavigationState.NavigationStateBack -> {
                    ApplicationHelper.hideKeyboard(baseActivity)
                    baseActivity.goBack()
                }
                else -> Unit
            }
        }
    }

    private fun getLeague(){
        teamViewModel.getAllTeams(basViewModel.nameGroup)
    }

    private fun initObservers() {
        teamViewModel.repository.liveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Result.TeamResult -> {
                    listTeams = response.teams.data.toList()

                    // Sort the list in reverse alphabetical order
                    listTeams = listTeams.sortedByDescending { it.strTeam }

                    // Filter the list to show only every other team
                    val filteredList = listTeams.filterIndexed { index, _ ->
                        index % 2 == 0
                    }
                    refreshRecycler(filteredList)
                }
                is Result.ErrorResult -> Log.d("ERROR", response.message)
                else -> Unit
            }
        }
    }


    private fun refreshRecycler(list : List<Team>) {
        teamAdapter = TeamAdapter(list, baseActivity)
        binding.recyclerView.apply {
            adapter = teamAdapter
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun initSearch(){
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredResults = listTeams.filter {
                    it.strTeam.contains(s.toString(), ignoreCase = true)
                }
                refreshRecycler(filteredResults)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    override fun onResume() {
        super.onResume()
        getLeague()
    }
}
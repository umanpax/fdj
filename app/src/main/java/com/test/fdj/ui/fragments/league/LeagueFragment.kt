package com.test.fdj.ui.fragments.league

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.test.fdj.databinding.FragmentLeagueBinding
import androidx.fragment.app.activityViewModels
import com.test.fdj.model.League
import com.test.fdj.ui.activities.base.BaseActivity
import com.test.fdj.ui.activities.base.BaseViewModel
import com.test.fdj.usecase.Result
import com.test.fdj.utils.ApplicationHelper
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeagueFragment : Fragment() {

    private val leagueViewModel: LeagueViewModel by viewModel()
    private val basViewModel: BaseViewModel by activityViewModels()
    private lateinit var binding: FragmentLeagueBinding
    private lateinit var baseActivity: BaseActivity
    private lateinit var leagueAdapter: LeagueAdapter
    private var listLeagues: List<League> = listOf()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreate(savedInstanceState)
        baseActivity = activity as BaseActivity
        binding = FragmentLeagueBinding.inflate(inflater, container, false)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = leagueViewModel
        }
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

    private fun initObservers() {
        leagueViewModel.repository.liveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Result.LeagueResult -> {
                    listLeagues = response.leagues.data.toList()
                    refreshRecycler(listLeagues)
                }
                is Result.ErrorResult -> Log.d("ERROR", response.message)
                else -> Unit
            }
        }
    }

    private fun refreshRecycler(list : List<League>) {
        leagueAdapter = LeagueAdapter(list, onItemClicked())
        binding.recyclerView.apply {
            adapter = leagueAdapter
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
        }
    }

    private fun initSearch(){
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filteredResults = listLeagues.filter {
                    it.strLeague.contains(s.toString(), ignoreCase = true)
                }
                refreshRecycler(filteredResults)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }

    private fun onItemClicked(): (onClickCallback: String) -> Unit {
        return { strLeague ->
            ApplicationHelper.hideKeyboard(baseActivity)
            basViewModel.nameGroup = strLeague
            baseActivity.apply {
                incrementCurrentItemViewPager()
                navigate()
            }
        }
    }

}
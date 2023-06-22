package com.test.fdj.ui.activities.base

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.test.fdj.databinding.ActivityBaseBinding
import com.test.fdj.ui.fragments.league.LeagueFragment
import com.test.fdj.ui.fragments.team.TeamFragment
import com.test.fdj.usecase.NavigationState
import com.test.fdj.utils.ApplicationHelper
import com.test.fdj.utils.BaseFragmentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BaseActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBaseBinding
    private val basViewModel: BaseViewModel by viewModel()
    private lateinit var leagueFragment: LeagueFragment
    private lateinit var teamFragment: TeamFragment
    private val mFragmentList: ArrayList<Fragment> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseBinding.inflate(layoutInflater).apply {
            lifecycleOwner = lifecycleOwner
            viewModel = basViewModel
        }
        val view = binding.root
        setContentView(view)
        initFragments()
        initViewPager()
        initObservers()
        initListeners()
    }

    private fun initFragments() {
        leagueFragment = LeagueFragment()
        teamFragment = TeamFragment()
        mFragmentList.add(leagueFragment)
        mFragmentList.add(teamFragment)
    }

    private fun initViewPager() {
        binding.viewPager.offscreenPageLimit = 2
        val tabsAdapter = BaseFragmentAdapter(
            supportFragmentManager, mFragmentList.size,
            mFragmentList, lifecycle
        )
        binding.viewPager.apply {
            adapter = tabsAdapter
            currentItem = 0
        }
    }

    private fun initObservers() {
        basViewModel.uiNavigationState.observe(this) { state ->
            when (state) {
                is NavigationState.NavigationStateBack -> goBack()
                else -> Unit
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initListeners() {
        binding.apply {
            viewPager.setOnTouchListener { _, _ -> false }
        }
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                goBack()
            }
        })
        binding.constraintBase.setOnClickListener {
            ApplicationHelper.hideKeyboard(this)
        }
    }

    fun incrementCurrentItemViewPager() {
        binding.viewPager.currentItem++
    }

     fun navigate() {
        binding.viewPager.setCurrentItem(getCurrentItemViewPager(), true)
    }

    private fun getCurrentItemViewPager(): Int {
        return binding.viewPager.currentItem
    }

    fun goBack() {
        if ( binding.viewPager.currentItem == 0) finish()
        else {
            binding.viewPager.currentItem--
            navigate()
        }
    }
}
package com.test.fdj.ui.fragments.league

import androidx.lifecycle.ViewModel
import com.test.fdj.model.League
import com.test.fdj.service.repository.Repository
import org.koin.core.component.KoinComponent

class LeagueViewModel(val repository: Repository) : ViewModel(), KoinComponent {

    init {
        getAllLeagues()
    }
    private fun getAllLeagues(){
        repository.getAllLeagues()
    }

}
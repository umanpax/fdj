package com.test.fdj.di

import com.test.fdj.service.ServiceGenerator
import com.test.fdj.service.repository.Repository
import com.test.fdj.ui.fragments.league.LeagueViewModel
import com.test.fdj.ui.fragments.team.TeamViewModel
import com.test.fdj.service.ws.DataManager
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val moduleRepository =
    module { factory { Repository(dataManager = DataManager(serviceGenerator = ServiceGenerator())) } }

val leagueViewModel = module {
    viewModel {
        LeagueViewModel(
            repository = Repository(
                dataManager = DataManager(serviceGenerator = ServiceGenerator())
            )
        )
    }
}

val teamViewModel = module {
    viewModel {
        TeamViewModel(
            repository = Repository(
                dataManager = DataManager(serviceGenerator = ServiceGenerator())
            )
        )
    }
}


val koinUiModules = listOf(
    moduleRepository,
    leagueViewModel,
    teamViewModel
)
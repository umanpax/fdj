package com.test.fdj.usecase

import com.test.fdj.model.Leagues
import com.test.fdj.model.Teams

sealed class Result {
    data class TeamResult(val teams: Teams) : Result()
    data class LeagueResult(val leagues: Leagues) : Result()
    data class ErrorResult(val message: String) : Result()
}

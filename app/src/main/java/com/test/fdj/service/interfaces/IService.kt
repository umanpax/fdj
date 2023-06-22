package com.test.fdj.service.interfaces

import com.test.fdj.model.Leagues
import com.test.fdj.model.Teams
import io.reactivex.Observable
import retrofit2.http.*

interface IService {

    /**
     * Get All Leagues
     * @return
     */
    @GET("api/v1/json/50130162/all_leagues.php")
    fun getAllLeagues(): Observable<Leagues>

    /**
     * Get All Teams
     * @return
     */
    @GET("api/v1/json/50130162/search_all_teams.php")
    fun getAllTeams(@Query("l") league: String): Observable<Teams>

}


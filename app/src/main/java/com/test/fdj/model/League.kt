package com.test.fdj.model

import java.io.Serializable

data class League(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String
) : Serializable

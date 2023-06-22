package com.test.fdj.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class League(
    @SerializedName("idLeague")
    @Expose
    val idLeague: String,
    @SerializedName("strLeague")
    @Expose
    val strLeague: String,
    @SerializedName("strSport")
    @Expose
    val strSport: String,
    @SerializedName("strLeagueAlternate")
    @Expose
    val strLeagueAlternate: String
) : Serializable

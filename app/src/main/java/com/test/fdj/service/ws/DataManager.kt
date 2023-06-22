package com.test.fdj.service.ws

import com.test.fdj.model.Leagues
import com.test.fdj.model.Teams
import com.test.fdj.service.ServiceGenerator
import com.test.fdj.service.interfaces.IService
import io.reactivex.Observable
import org.intellij.lang.annotations.Language
import org.koin.core.component.KoinComponent

/**
 * Created by pierre-alexandrevezinet on 20/02/2019.
 *
 */
class  DataManager(private val serviceGenerator: ServiceGenerator) : KoinComponent {

    fun getAllLeagues(): Observable<Leagues> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.getAllLeagues()
    }

    fun getAllTeams(lang: String): Observable<Teams> {
        val service = serviceGenerator.createServiceLessToken(IService::class.java)
        return service.getAllTeams(lang)
    }

}



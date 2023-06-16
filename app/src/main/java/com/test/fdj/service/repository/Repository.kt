package com.test.fdj.service.repository

import androidx.lifecycle.MutableLiveData
import com.test.fdj.model.Leagues
import com.test.fdj.model.Teams
import com.test.fdj.service.ws.DataManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Repository(private val dataManager: DataManager) {

    val liveData = MutableLiveData<Any>()

    fun getAllLeagues() {
        dataManager.getAllLeagues()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Leagues> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: Leagues) {
                    liveData.postValue(response)
                }

                override fun onError(e: Throwable) {
                    liveData.postValue(e.message.toString())
                }

                override fun onComplete() {

                }

            })
    }

    fun getAllTeams(lang: String) {
        dataManager.getAllTeams(lang)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Teams> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: Teams) {
                    liveData.postValue(response)
                }

                override fun onError(e: Throwable) {
                    liveData.postValue(e.message.toString())
                }

                override fun onComplete() {

                }

            })
    }
}
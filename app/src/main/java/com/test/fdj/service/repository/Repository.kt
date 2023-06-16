package com.test.fdj.service.repository

import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.titre.services.ws.DataManager
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class Repository(private val dataManager: DataManager) {

    val liveData = MutableLiveData<Any>()

    fun login(loginpwd: String, place: String) {
        dataManager.login(loginpwd, place)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<Token> {
                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: Token) {
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
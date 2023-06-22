package com.test.fdj.ui.fragments.team

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.fdj.service.repository.Repository
import com.test.fdj.usecase.NavigationState
import org.koin.core.component.KoinComponent

class TeamViewModel(val repository: Repository) : ViewModel(), KoinComponent {

    private var _uiNavigationState = MutableLiveData<NavigationState>()
    val uiNavigationState: LiveData<NavigationState> = _uiNavigationState

     fun getAllTeams(league : String){
        repository.getAllTeams(league)
    }

    fun back(){
        _uiNavigationState.postValue(NavigationState.NavigationStateBack)
    }

}
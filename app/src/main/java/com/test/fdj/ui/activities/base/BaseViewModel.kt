package com.test.fdj.ui.activities.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.test.fdj.usecase.NavigationState
import org.koin.core.component.KoinComponent

class BaseViewModel : ViewModel(), KoinComponent {

    var nameGroup = ""
    private var _uiNavigationState = MutableLiveData<NavigationState>()
    val uiNavigationState: LiveData<NavigationState> = _uiNavigationState

    fun back() {
        _uiNavigationState.postValue(NavigationState.NavigationStateBack)
    }

}
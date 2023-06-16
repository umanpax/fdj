package com.test.fdj.usecase

sealed class ResultState {
    data class Success(val data : Any) : ResultState()
    data class Failure(val exception : String) : ResultState()
}
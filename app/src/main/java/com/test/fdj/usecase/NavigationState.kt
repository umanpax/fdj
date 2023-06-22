package com.test.fdj.usecase

sealed class NavigationState{
    object NavigationStateNext : NavigationState()
    object NavigationStateBack : NavigationState()
}

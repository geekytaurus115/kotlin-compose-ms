package com.example.view_model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel(){
    var username = mutableStateOf("")
    var password = mutableStateOf("")
    var isLoggedIn = mutableStateOf(false)

    fun onLoginClick(){
        isLoggedIn.value = username.value == "admin" && password.value == "1234"
    }

}
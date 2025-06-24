package com.example.view_model

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class CounterViewModel : ViewModel() {

    // State managed inside the ViewModel
    var count by mutableStateOf(0)
        private set

    fun incrementCount() {
        count++
    }
}

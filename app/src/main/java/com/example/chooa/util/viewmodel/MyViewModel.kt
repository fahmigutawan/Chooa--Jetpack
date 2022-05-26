package com.example.chooa.util.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    // Onboard screen attributes
    var onboardTextField by mutableStateOf("")

    // Home screen attributes
    var homeName by mutableStateOf(". . .")
}
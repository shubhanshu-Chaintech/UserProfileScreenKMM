@file:OptIn(ExperimentalFoundationApi::class)

package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){

    var state by mutableStateOf(ProfileState())
        private set

    fun onAction(action:ProfileAction){
        when(action){
            ProfileAction.onSaveClick -> TODO()
        }
    }
}
@file:OptIn(ExperimentalFoundationApi::class)

package ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class ProfileState(
    var name:TextFieldState = TextFieldState(),
    var email:TextFieldState = TextFieldState(),
    var password:TextFieldState= TextFieldState(),
    var dateOfBirth:String = "",
    val mobileNumber:String= ""
)
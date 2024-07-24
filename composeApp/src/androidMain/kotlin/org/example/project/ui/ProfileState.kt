@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState
import org.example.project.domain.PasswordValidationState

data class ProfileState(
    var name:TextFieldState = TextFieldState(),
    var email:TextFieldState = TextFieldState(),
    var password:TextFieldState= TextFieldState(),
    var dateOfBirth:String = "",
    val mobileNumber:String= "",
    val isPasswordVisible:Boolean = false,
    val isEmailValid:Boolean =false,
    val canSave:Boolean =false,
    val passwordValidationState: PasswordValidationState = PasswordValidationState()
)
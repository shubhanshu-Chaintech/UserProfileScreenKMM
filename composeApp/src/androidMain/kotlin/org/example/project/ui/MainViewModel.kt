@file:OptIn(ExperimentalFoundationApi::class)

package org.example.project.ui

import android.util.Patterns
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.example.project.domain.PasswordValidationState

class MainViewModel(
) :ViewModel(){
    var state by mutableStateOf(ProfileState())
        private set
//    init {
//        state.email.textAsFlow().onEach { email ->
//            val isEmailValid = isValidEmail(email.toString())
//            state = state.copy(
//                isEmailValid = isEmailValid,
//                canSave = isEmailValid && state.passwordValidationState.isValidPassword
//            )
//        }
//            .launchIn(viewModelScope)
//
//        state.password.textAsFlow().onEach { password ->
//            val passwordValidationState = validatePassword(password.toString())
//            state = state.copy(
//                passwordValidationState = passwordValidationState,
//                canSave = state.isEmailValid && passwordValidationState.isValidPassword
//            )
//        }
//            .launchIn(viewModelScope)
//    }

    fun onAction(action:ProfileAction){
        when(action){
            ProfileAction.onSaveClick -> TODO()
            ProfileAction.onTogglePossibilityClick -> state = state.copy(
                isPasswordVisible = !state.isPasswordVisible
            )
        }
    }
    //validation
    fun isValidEmail(email: String): Boolean? {
        return null
    }

    fun validatePassword(password: String): PasswordValidationState {
        val hasMinLength = password.length >= PASSWORD_MIN_LENGTH
        val hasDigit = password.any { it.isDigit() }
        val hasLowerCaseCharacter = password.any { it.isLowerCase() }
        val hasUppercaseCharacter = password.any { it.isUpperCase() }

        return PasswordValidationState(
            hasMinLength = hasMinLength,
            hasNumber = hasDigit,
            hasLowerCaseCharacter = hasLowerCaseCharacter,
            hasUpperCaseCharacter = hasUppercaseCharacter
        )
    }
    object EmailPatternValidator: PattenValidator {
        override fun matches(value: String): Boolean {
            return Patterns.EMAIL_ADDRESS.matcher(value).matches()
        }

    }

    interface PattenValidator {
        fun matches(value:String):Boolean
    }

    companion object {
        const val PASSWORD_MIN_LENGTH = 9
    }
}
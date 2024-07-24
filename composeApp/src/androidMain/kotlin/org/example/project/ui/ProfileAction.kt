package org.example.project.ui

sealed interface ProfileAction{
    data object onSaveClick :ProfileAction
    data object onTogglePossibilityClick:ProfileAction

}
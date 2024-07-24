@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class, ExperimentalFoundationApi::class,
    ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class,
    ExperimentalFoundationApi::class
)

package org.example.project.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import network.chaintech.ui.datepicker.WheelDatePickerDialog
import org.example.project.CheckIcon
import org.example.project.EmailIcon
import org.example.project.components.CountryPickerBasicText
import org.example.project.components.PhotoCrop
import org.example.project.components.ProfilePasswordTextField
import org.example.project.components.RuniqueTextField

@Composable
fun ProfileScreenRoot(
    viewModel: MainViewModel =MainViewModel()
) {
    ProfileScreenMain(
        state = viewModel.state,
        onAction = {action -> viewModel.onAction(action)        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScreenMain(
    state: ProfileState = ProfileState(),
    onAction : (ProfileAction) -> Unit
) {

    Scaffold(modifier = Modifier.padding(20.dp),
        topBar = {
            TopAppBar(title = {
                Text(
                    "Edit Profile",
                )
            }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(13.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(38.dp))

            PhotoCrop()

            RuniqueTextField(
                state = state.name,
                startIcon = Icons.Default.Person,
                title = "Name",
                hint = "Name",
                keyboardType = KeyboardType.Text,
                endIcon = null,
                modifier = Modifier.fillMaxWidth())
            RuniqueTextField(
                state = state.email,
                title = "Email",
                hint ="Email",
                startIcon = EmailIcon,
                endIcon = if(state.isEmailValid) CheckIcon else null,
                modifier = Modifier.fillMaxWidth()
            )
            ProfilePasswordTextField(
                state = state.password,
                isPasswordVisible = state.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onAction(ProfileAction.onTogglePossibilityClick)
                },
                hint = "Password",
                title = "Password",
                modifier = Modifier.fillMaxWidth()
            )
            var showDatePicker by remember { mutableStateOf(false) }
            WheelDatePickerDialog(
                modifier = Modifier.padding(20.dp),
                title = "Date of Birth",
                showDatePicker = showDatePicker,
                height = 300.dp,
                onDoneClick = { date ->
                    state.dateOfBirth= date.toString()
                    showDatePicker = false
                }
            )
            OutlinedTextField(
                value = state.dateOfBirth.toString(),
                onValueChange = { state.dateOfBirth = it },
                label = { Text("Date of Birth",
                    textAlign = TextAlign.Center)},
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable { showDatePicker = true }
                    )
                },modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp)
            )

            // Country/ Region
            CountryPickerBasicText()
            // Save Changes Button
            Button(onClick = {
            }) {
                Text("Save Changes")
            }
        }
    }
}

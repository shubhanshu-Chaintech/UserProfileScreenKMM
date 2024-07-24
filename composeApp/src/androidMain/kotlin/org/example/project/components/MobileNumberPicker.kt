package org.example.project.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import network.chaintech.cmpcountrycodepicker.model.CountryDetails
import network.chaintech.cmpcountrycodepicker.ui.CountryPickerBasicTextField

@Composable
fun CountryPickerBasicText() {
    val selectedCountryState: MutableState<CountryDetails?> = remember {
        mutableStateOf(null)
    }
    var mobileNumber by remember {
        mutableStateOf("")
    }

    CountryPickerBasicTextField(
        mobileNumber = mobileNumber,
        defaultCountryCode = "in",
        onMobileNumberChange = {
            mobileNumber = it
        },
        onCountrySelected = {
            selectedCountryState.value = it
        },
        modifier = Modifier.fillMaxWidth(),
        defaultPaddingValues = PaddingValues(5.dp),
        showCountryFlag = true,
        showCountryPhoneCode = true,
        showCountryName = false,
        showCountryCode = false,
        showArrowDropDown = true,
        spaceAfterCountryFlag = 8.dp,
        spaceAfterCountryPhoneCode = 6.dp,
        spaceAfterCountryName = 6.dp,
        spaceAfterCountryCode = 6.dp,
        label = {
            Text(text = "Mobile Number")
        },
        focusedBorderThickness = 2.dp,
        unfocusedBorderThickness = 1.dp,
        shape = RoundedCornerShape(10.dp),
        verticalDividerColor = Color(0XFFDDDDDD),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = Color.Gray,
            unfocusedBorderColor = Color.Gray
        )
    )
}
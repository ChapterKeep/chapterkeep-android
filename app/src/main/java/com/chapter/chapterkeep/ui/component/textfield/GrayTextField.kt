package com.chapter.chapterkeep.ui.component.textfield

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrayISBNTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    shape: Int,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, color = colorResource(R.color.gray_500), fontSize = 10.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 10.sp
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            containerColor = colorResource(R.color.gray_300),
            focusedLabelColor = colorResource(id = R.color.gray_700),
            unfocusedLabelColor = colorResource(id = R.color.gray_700)
        ),
        modifier = modifier,
        shape = RoundedCornerShape(shape.dp)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrayTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    shape: Int,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(text = placeholder, color = colorResource(R.color.gray_500), fontSize = 10.sp) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        textStyle = androidx.compose.ui.text.TextStyle(
            fontSize = 13.sp
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Transparent,
            unfocusedBorderColor = Color.Transparent,
            containerColor = colorResource(R.color.gray_300),
            focusedLabelColor = colorResource(id = R.color.gray_700),
            unfocusedLabelColor = colorResource(id = R.color.gray_700)
        ),
        modifier = modifier,
        shape = RoundedCornerShape(shape.dp)
    )
}
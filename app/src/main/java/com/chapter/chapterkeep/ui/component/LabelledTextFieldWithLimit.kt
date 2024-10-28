package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LabelledTextFieldWithLimit(
    value: String,
    onValueChange: (String) -> Unit,
    textLabel: String,
    fieldLabel: String,
    maxLength: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    height: Int
) {
    Column {
        Text(
            text = textLabel,
            color = colorResource(R.color.gray_600),
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(10.dp))

        OutlinedTextField(
            value = value,
            onValueChange = {
                if (it.length <= maxLength) {
                    onValueChange(it)
                }
            },
            label = { Text(text = fieldLabel) },
            keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.gray_500),
                unfocusedBorderColor = colorResource(id = R.color.gray_500),
                focusedLabelColor = colorResource(id = R.color.gray_600),
                unfocusedLabelColor = colorResource(id = R.color.gray_600)
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(height.dp),
            shape = RoundedCornerShape(8.dp)
        )
    }
}
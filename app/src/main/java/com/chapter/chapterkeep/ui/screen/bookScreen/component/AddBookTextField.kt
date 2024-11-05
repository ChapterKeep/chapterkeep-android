package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.chapter.chapterkeep.ui.component.textfield.GrayTextField

@Composable
fun AddBookTextField(
    title: Int,
    value: String,
    onValueChange: (String)->Unit,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    shape: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        AddBookTitle(title)
        Spacer(modifier = Modifier.height(8.dp))

        GrayTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = "",
            keyboardType = keyboardType,
            imeAction = imeAction,
            shape = shape,
            modifier = modifier
        )
    }
}
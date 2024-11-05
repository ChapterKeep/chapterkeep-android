package com.chapter.chapterkeep.ui.component.textfield

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.CommonButton


@Composable
fun InputWithCheckSection(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    maxLength: Int,
    isAvailable: Boolean,
    availableMessage: Int,
    unavailableMessage: Int,
    isClicked: Boolean,
    onCheckClick: () -> Unit
) {
    Column(
        modifier = Modifier.padding(bottom = 20.dp)
    ) {
        LimitTextField(
            value = value,
            onValueChange = onValueChange,
            label = label,
            keyboardType = keyboardType,
            imeAction = imeAction,
            maxLength = maxLength
        )
        Spacer(Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = if (isClicked) {
                    stringResource(id = if (isAvailable) availableMessage else unavailableMessage)
                } else {
                    ""
                },
                color = colorResource(R.color.gray_700),
                fontSize = 13.sp
            )

            CommonButton(
                label = stringResource(R.string.check),
                13
            ) {
                onCheckClick()
            }
        }
    }
}
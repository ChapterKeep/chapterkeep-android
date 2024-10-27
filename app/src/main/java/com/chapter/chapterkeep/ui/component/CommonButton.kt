package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun ChangeButton(
    label: String,
    color: () -> Int,
    fontColor: () -> Int,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        contentPadding = PaddingValues(12.dp),
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(colorResource(id = color())),
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = label,
            fontSize = 18.sp,
            color = colorResource(id = fontColor())
        )
    }
}

@Composable
fun CommonButton(
    label: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.main_green)),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(
            text = label,
            fontSize = 13.sp,
            color = colorResource(id = R.color.white)
        )
    }
}
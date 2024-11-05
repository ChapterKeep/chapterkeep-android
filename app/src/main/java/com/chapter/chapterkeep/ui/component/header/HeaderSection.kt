package com.chapter.chapterkeep.ui.component.header

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .background(colorResource(id = R.color.main_green)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            color = colorResource(R.color.white),
            fontWeight = FontWeight.Black,
            fontSize = 30.sp
        )
        Text(
            text = stringResource(R.string.app_sub_name),
            color = colorResource(R.color.white),
            fontSize = 15.sp
        )
        Spacer(Modifier.height(13.dp))

        Divider(thickness = 4.dp, color = Color.White)
        Spacer(Modifier.height(13.dp))
    }
}
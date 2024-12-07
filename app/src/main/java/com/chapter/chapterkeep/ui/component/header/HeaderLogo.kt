package com.chapter.chapterkeep.ui.component.header

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.CommonButtonWithVector

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderWhiteLogo() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.img_chapterkeep_whitelogo_text),
                contentDescription = "로고 이미지",
                modifier = Modifier
                    .size(width = 102.dp, height = 18.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderGreenLogo() {
    TopAppBar(
        title = {
            Image(
                painter = painterResource(id = R.drawable.img_chapterkeep_greenlogo_text),
                contentDescription = "로고 이미지",
                modifier = Modifier
                    .size(width = 102.dp, height = 18.dp)
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeaderWhiteLogoWithBtn(
    label: Int,
    image: Int,
    onClick: ()-> Unit
) {
    TopAppBar(
        title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.img_chapterkeep_whitelogo_text),
                    contentDescription = "로고 이미지",
                    modifier = Modifier
                        .size(width = 102.dp, height = 18.dp)
                )

                CommonButtonWithVector(
                    label = label,
                    image = image
                ) {
                    onClick()
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent)
    )
}
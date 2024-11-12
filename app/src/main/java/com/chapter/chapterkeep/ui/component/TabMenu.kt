package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun TabMenu(
    bookCheck: Boolean,
    profileCheck: Boolean,
    onChanged: () -> Unit
) {
    // 메뉴 탭
    val textSize: TextUnit = 16.sp
    val underline = 3.dp

    Column {
        Row(
            modifier = Modifier.padding(start = 50.dp)
        ) {
            Column(
                modifier = Modifier
                    .size(90.dp, 50.dp)
                    .clickable { onChanged() },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.search_book),
                    fontSize = textSize,
                    color =
                    if (bookCheck)
                        colorResource(id = R.color.main_green)
                    else
                        colorResource(id = R.color.gray_700)
                )

                if (bookCheck) {
                    Divider(
                        color = colorResource(id = R.color.black),
                        modifier = Modifier
                            .width(90.dp)
                            .height(underline)
                            .offset(y = 13.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .size(90.dp, 50.dp)
                    .clickable {
                        onChanged()
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.search_profile),
                    fontSize = textSize,
                    color =
                    if (profileCheck)
                        colorResource(id = R.color.main_green)
                    else
                        colorResource(id = R.color.gray_700)
                )

                if (profileCheck) {
                    Divider(
                        color = colorResource(id = R.color.black),
                        modifier = Modifier
                            .width(90.dp)
                            .height(underline)
                            .offset(y = 13.dp)
                    )
                }
            }

        }
    }
}
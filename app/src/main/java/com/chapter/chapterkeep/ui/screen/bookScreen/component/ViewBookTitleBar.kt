package com.chapter.chapterkeep.ui.screen.bookScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.DropDownMenu

@Composable
fun ViewBookTitleBar(
    title: String,
    date: String,
    starStates: MutableList<Boolean>,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold
            )

            DropDownMenu(navController)
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = date,
                fontSize = 10.sp,
                color = colorResource(R.color.gray_600),
            )

            Row(

            ) {
                starStates.forEachIndexed { index, isYellow ->
                    Image(
                        painter = painterResource(
                            if (isYellow) R.drawable.ic_star_yellow else R.drawable.ic_star_gray
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(17.dp)
                    )

                    if (index < starStates.size - 1) {
                        Spacer(modifier = Modifier.width(3.dp))
                    }
                }
            }
        }
    }
}
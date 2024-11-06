package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun ProfileBar(
    navController: NavHostController,
    userNickName: String,
    userMyself: String,
    userBookCount: Int
) {
    Box(
        modifier = Modifier
            .height(141.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile_bar),
            contentDescription = null,
            modifier = Modifier
                .height(141.dp)
                .fillMaxWidth()
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.img_profile_select),
                    contentDescription = "",
                    modifier = Modifier
                        .size(60.dp)
                        .border(
                            width = 2.5.dp,
                            color = colorResource(R.color.main_green),
                            shape = CircleShape
                        )
                )
                Spacer(Modifier.height(7.dp))

                CommonButton(
                    label = stringResource(R.string.editprofile_title),
                    fontSize = 10
                ) {
                    navController.navigate(Routes.EditProfile.route)
                }
            }
            Spacer(modifier = Modifier.width(60.dp))

            Column(
                modifier = Modifier.fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = userNickName,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = userMyself,
                    fontSize = 10.sp,
                    modifier = Modifier.padding(bottom = 15.dp)
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.home_book_count),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end = 15.dp)
                    )

                    Text(
                        text = userBookCount.toString() + stringResource(R.string.home_book),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}
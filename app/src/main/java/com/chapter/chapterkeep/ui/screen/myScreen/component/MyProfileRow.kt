package com.chapter.chapterkeep.ui.screen.myScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun MyProfileRow(
    userName: String,
    writeAccount: Int,
    logoutOnClick: () -> Unit,
    deleteOnClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile_select),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(
                    width = 2.5.dp,
                    color = colorResource(R.color.main_green),
                    shape = CircleShape
                ),
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.width(32.dp))

        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row{
                Text(
                    text = userName,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = colorResource(R.color.main_green)
                )

                Text(
                    text = stringResource(R.string.mypage_profile_nickname),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
            }

            Text(
                text = stringResource(R.string.mypage_profile_write_count, writeAccount.toString()),
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold
            )

            Row {
                Text(
                    text = stringResource(R.string.mypage_profile_logout),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(R.color.gray_700),
                    modifier = Modifier
                        .padding(end = 5.dp)
                        .clickable {
                            logoutOnClick()
                        }
                )
                Text(
                    text = stringResource(R.string.mypage_profile_divider),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(R.color.gray_700)
                )
                Text(
                    text = stringResource(R.string.mypage_profile_delete_account),
                    fontSize = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = colorResource(R.color.gray_700),
                    modifier = Modifier
                        .padding(start = 5.dp)
                        .clickable {
                            deleteOnClick()
                        }
                )
            }
        }
    }
}
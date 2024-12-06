package com.chapter.chapterkeep.ui.screen.myScreen.component

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.api.dto.response.PostsData
import com.chapter.chapterkeep.ui.component.DropDownMenu

@Composable
fun MoreItem(
    post: PostsData,
    navController: NavHostController
) {
    Column(
        modifier= Modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = colorResource(R.color.main_green),
                shape = RoundedCornerShape(12.dp)
            )
            .padding(15.dp)
            .clickable {
                navController.navigate("ViewBaekiljang/${post.postId}")
            }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = post.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
            
            DropDownMenu(navController)
        }
        Spacer(Modifier.height(5.dp))

        Text(
            text = stringResource(
                R.string.mypage_profile_time_writer,
                post.createdAt,
                post.nickname
            ),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            color = colorResource(R.color.gray_800)
        )
    }
}

package com.chapter.chapterkeep.ui.screen.myScreen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.model.PostData

@Composable
fun MyPostList(
    title: String,
    posts: List<PostData>
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold
        )
        Spacer(Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = colorResource(R.color.sub_green).copy(alpha = 0.11f),
                    shape = RoundedCornerShape(20.dp)
                )
                .padding(20.dp)
        ) {
            posts.forEach { post ->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // 각 게시글로 이동
                        }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = post.title,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold
                        )

                        Image(
                            painter = painterResource(R.drawable.img_my_more),
                            contentDescription = null,
                            modifier = Modifier.size(13.dp)
                        )
                    }

                    Text(
                        text = stringResource(
                            R.string.mypage_profile_time_writer,
                            post.time,
                            post.writer
                        ),
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        color = colorResource(R.color.gray_800)
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }

            Divider(color = Color.White)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .clickable {
                        // 각 게시글 모아보기로 이동
                    },
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(R.string.mypage_profile_more),
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Medium,
                    modifier= Modifier.padding(end = 5.dp),
                    color = colorResource(R.color.gray_700)
                )
                Image(
                    painter = painterResource(R.drawable.img_my_more_grey),
                    contentDescription = null,
                    modifier = Modifier.size(12.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun MyWriteListPreview() {
    MyPostList(
        title = "내가 쓴 게시글",
        posts = listOf(
            PostData(
                title = "첫 번째 게시글 제목",
                time = "2024-11-25",
                writer = "작성자 A"
            ),
            PostData(
                title = "두 번째 게시글 제목",
                time = "2024-11-24",
                writer = "작성자 B"
            )
        )
    )
}
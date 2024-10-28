package com.chapter.chapterkeep.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.chapter.chapterkeep.R

@Composable
fun InputWithImage() {
    Text(
        text = stringResource(R.string.signup_profile),
        color = colorResource(R.color.gray_600),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(Modifier.height(10.dp))

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.img_profile_select),
            contentDescription = "회원가입_프로필사진",
            modifier = Modifier.size(100.dp)
        )
        Spacer(Modifier.height(8.dp))

        Button(
            onClick = {
                TODO("사진 등록")
            },
            contentPadding = PaddingValues(12.dp, 0.dp),
            colors = ButtonDefaults.buttonColors(colorResource(R.color.gray_400)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                text = stringResource(R.string.signup_profile_button),
                fontSize = 14.sp,
                color = colorResource(R.color.gray_600)
            )
        }
    }

    Spacer(modifier = Modifier.height(15.dp))
}
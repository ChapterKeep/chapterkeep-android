package com.chapter.chapterkeep.screen.loginScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.common.ChangeButton
import com.chapter.chapterkeep.common.CommonButton
import com.chapter.chapterkeep.common.LimitTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignupScreen_NickName(navController: NavHostController) {
    var userNickName by remember {
        mutableStateOf("")
    }
    var userMyself by remember{
        mutableStateOf("")
    }
    val isButtonEnabled = userNickName.isNotEmpty() && userMyself.isNotEmpty()
    val scrollstate = rememberScrollState()
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(colorResource(id = R.color.main_green)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
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
        Spacer(Modifier.height(7.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
                .verticalScroll(scrollstate),
        ) {
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
                        // 이미지 추가
                    },
                    contentPadding = PaddingValues(12.dp,0.dp),
                    colors = ButtonDefaults.buttonColors(colorResource(R.color.gray_400)),
                    shape = RoundedCornerShape(12.dp)
                ){
                    Text(
                        text = stringResource(R.string.signup_profile_button),
                        fontSize = 14.sp,
                        color = colorResource(R.color.gray_600)
                    )
                }
            }

            LimitTextField(
                value = userNickName,
                onValueChange = {userNickName = it},
                label = stringResource(R.string.signup_nickname),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done,
                maxLength = 10
            )
            Spacer(Modifier.height(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = stringResource(R.string.signup_nickname_possible),
                    color = colorResource(R.color.gray_600),
                    fontSize = 13.sp
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    CommonButton(
                        label = stringResource(R.string.check)
                    ) {
                        // 중복 확인
                    }
                }
            }
            Spacer(Modifier.height(27.dp))

            Text(
                text = stringResource(R.string.signup_myself),
                color = colorResource(R.color.gray_600),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))

            OutlinedTextField(
                value = userMyself,
                onValueChange = {
                    if (it.length <= 80) {
                        userMyself = it
                    }
                },
                label = { Text(text = stringResource(R.string.signup_myself_field)) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = colorResource(id = R.color.gray_500),
                    unfocusedBorderColor = colorResource(id = R.color.gray_500),
                    focusedLabelColor = colorResource(id = R.color.gray_600),
                    unfocusedLabelColor = colorResource(id = R.color.gray_600)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp),
                shape = RoundedCornerShape(8.dp)
            )
            Spacer(Modifier.height(25.dp))

            ChangeButton(
                label = stringResource(R.string.signup_button),
                color = {if (isButtonEnabled) R.color.main_green else R.color.gray_400},
                fontColor = {if(isButtonEnabled) R.color.white else R.color.gray_600 }
            ) {
                if (isButtonEnabled){
                    navController.navigate("Login")
                    Toast.makeText(context, "회원가입 성공",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
package com.chapter.chapterkeep.screen.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
import com.chapter.chapterkeep.common.PassWordTextField

@Composable
fun SignupScreen_ID(navController: NavHostController) {
    var userID by remember {
        mutableStateOf("")
    }
    var userPassWord by remember{
        mutableStateOf("")
    }
    var userCheckPassWord by remember{
        mutableStateOf("")
    }

    val isButtonEnabled = userID.isNotEmpty() && userPassWord.isNotEmpty() && (userPassWord == userCheckPassWord)

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
                .fillMaxWidth()
                .padding(20.dp),
        ) {
            Text(
                text = stringResource(R.string.signup_id),
                color = colorResource(R.color.gray_600),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))

            LimitTextField(
                value = userID,
                onValueChange = {userID = it},
                label = stringResource(R.string.id),
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
                    text = stringResource(R.string.signup_id_possible),
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
                text = stringResource(R.string.signup_password),
                color = colorResource(R.color.gray_600),
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(10.dp))

            PassWordTextField(
                value = userPassWord,
                onValueChange = {userPassWord = it},
                label = stringResource(R.string.password),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
            Spacer(Modifier.height(10.dp))

            PassWordTextField(
                value = userCheckPassWord,
                onValueChange = {userCheckPassWord = it},
                label = stringResource(R.string.checkpassword),
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
            Spacer(Modifier.height(10.dp))

            if(userPassWord != userCheckPassWord){
                Text(
                    text = stringResource(R.string.signup_password_incorrect),
                    fontSize = 13.sp,
                    color = colorResource(R.color.gray_600)
                )
            }

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.Bottom
        ){
            ChangeButton(
                label = stringResource(R.string.next_button),
                color = {if (isButtonEnabled) R.color.main_green else R.color.gray_400},
                fontColor = {if(isButtonEnabled) R.color.white else R.color.gray_600 }
            ) {
                if (isButtonEnabled){
                    navController.navigate("Signup_NickName")
                }
            }
        }
    }
}
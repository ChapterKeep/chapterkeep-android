package com.chapter.chapterkeep.ui.screen.loginScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.ChangeButton
import com.chapter.chapterkeep.ui.component.DoubleBackPressToExit
import com.chapter.chapterkeep.ui.component.textfield.CommonTextField
import com.chapter.chapterkeep.ui.component.textfield.PassWordTextField
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.homeScreen.HomeViewModel

@Composable
fun LoginScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    homeViewModel: HomeViewModel
) {
    val userID by loginViewModel::userID
    val userPassWord by loginViewModel::userPassWord
    val isButtonEnabled = userID.isNotEmpty() && userPassWord.isNotEmpty()

    DoubleBackPressToExit()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(150.dp))
        Column {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = colorResource(R.color.main_green),
                    fontWeight = FontWeight.Black,
                    fontSize = 30.sp
                )

                Text(
                    text = stringResource(R.string.app_sub_name),
                    color = colorResource(R.color.main_green),
                    fontSize = 15.sp
                )
                Spacer(Modifier.height(33.dp))
            }
            Column {
                CommonTextField(
                    value = userID,
                    onValueChange = { loginViewModel.updateUserId(it) },
                    label = stringResource(R.string.id),
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next,
                    shape = 8
                )
                Spacer(Modifier.height(16.dp))

                PassWordTextField(
                    value = userPassWord,
                    onValueChange = { loginViewModel.updateUserPassword(it) },
                    label = stringResource(R.string.password),
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                )
                Spacer(Modifier.height(25.dp))

                ChangeButton(
                    label = stringResource(R.string.login),
                    color = { if (isButtonEnabled) R.color.main_green else R.color.gray_200 },
                    fontColor = { if (isButtonEnabled) R.color.white else R.color.gray_700 }
                ) {
                    if (isButtonEnabled) {
                        loginViewModel.login(loginViewModel.userID, loginViewModel.userPassWord){nickName, myself ->
                            homeViewModel.updateUserNickName(nickName)
                            homeViewModel.updateUserMyself(myself)
                            navController.navigate(Routes.Home.route) {
                                popUpTo(Routes.Login.route) { inclusive = true }
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.signup),
                color = colorResource(R.color.gray_800),
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    navController.navigate(Routes.Signup_ID.route)
                }
            )
        }

    }
}
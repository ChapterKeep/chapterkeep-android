package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
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
import com.chapter.chapterkeep.ui.component.ChangeButton
import com.chapter.chapterkeep.ui.component.HeaderLogo
import com.chapter.chapterkeep.ui.component.InputWithCheckSection
import com.chapter.chapterkeep.ui.component.InputWithImage
import com.chapter.chapterkeep.ui.component.LabelledTextFieldWithLimit
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun EditProfileScreen(
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    var userNickName by remember { mutableStateOf(viewModel.userNickName) }
    var userMyself by remember { mutableStateOf(viewModel.userMyself) }

    Scaffold(
        topBar = { HeaderLogo() },
        containerColor = colorResource(R.color.main_green).copy(alpha = 0.7f)
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .shadow(8.dp, RoundedCornerShape(12.dp))
                .clip(RoundedCornerShape(12.dp))
                .background(color = Color.White)
                .padding(20.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.editprofile_title),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.main_green)
                    )

                    Image(
                        painter = painterResource(R.drawable.img_btn_cancel),
                        contentDescription = "뒤로가기",
                        modifier = Modifier
                            .size(20.dp)
                            .clickable {
                                navController.navigate(Routes.Home.route) {
                                    popUpTo(Routes.Home.route) { inclusive = true }
                                }
                            }
                    )
                }

                InputWithImage()

                InputWithCheckSection(
                    value = userNickName,
                    onValueChange = { userNickName = it },
                    label = stringResource(R.string.signup_nickname),
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done,
                    maxLength = 10,
                    isAvailable = viewModel.isNickNameAvailable,
                    availableMessage = R.string.signup_nickname_possible,
                    unavailableMessage = R.string.signup_nickname_impossible,
                    isClicked = viewModel.isNickNameClicked,
                    onCheckClick = { viewModel.checkNickNameAvailability() }
                )

                LabelledTextFieldWithLimit(
                    value = userMyself,
                    onValueChange = { userMyself = it },
                    textLabel = stringResource(R.string.signup_myself),
                    fieldLabel = userMyself,
                    maxLength = 80,
                    height = 130
                )
            }

            ChangeButton(
                label = stringResource(R.string.editprofile_button),
                color = { R.color.main_green },
                fontColor = { R.color.white }
            ) {
                viewModel.updateUserNickName(nickname = userNickName)
                viewModel.updateUserMyself(myself = userMyself)

                navController.navigate(Routes.Home.route) {
                    popUpTo(Routes.Home.route) { inclusive = true }
                }
            }

        }
    }
}
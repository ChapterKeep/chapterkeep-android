package com.chapter.chapterkeep.ui.screen.signupScreen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.ChangeButtonWithBottom
import com.chapter.chapterkeep.ui.component.header.HeaderSection
import com.chapter.chapterkeep.ui.component.textfield.InputWithCheckSection
import com.chapter.chapterkeep.ui.component.textfield.InputWithImage
import com.chapter.chapterkeep.ui.component.textfield.LabelledTextFieldWithLimit
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun SignUpScreen_NickName(
    navController: NavHostController,
    viewModel: SignUpViewModel
) {
    val userNickName by viewModel::userNickName
    val userMyself by viewModel::userMyself
    val isButtonEnabled = viewModel.isNickNameInfoValid && viewModel.isNickNameAvailable

    val scrollstate = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = { HeaderSection() },
        bottomBar = {
            ChangeButtonWithBottom(
                label = stringResource(R.string.signup_button),
                color = { if (isButtonEnabled) R.color.main_green else R.color.gray_200 },
                fontColor = { if (isButtonEnabled) R.color.white else R.color.gray_700 }
            ) {
                if (isButtonEnabled) {
                    viewModel.clearData()
                    navController.navigate(Routes.Login.route) {
                        popUpTo(Routes.Login.route) { inclusive = true }
                    }
                    Toast.makeText(context, "회원가입 성공", Toast.LENGTH_SHORT).show()
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp)
                .verticalScroll(scrollstate)
        ) {
            InputWithImage()

            InputWithCheckSection(
                value = userNickName,
                onValueChange = { viewModel.updateUserNickName(it) },
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
            Spacer(Modifier.height(27.dp))

            LabelledTextFieldWithLimit(
                value = userMyself,
                onValueChange = { viewModel.updateUserMyself(it) },
                textLabel = stringResource(R.string.signup_myself),
                fieldLabel = stringResource(R.string.signup_myself_field),
                maxLength = 80,
                height = 130
            )
        }
    }
}
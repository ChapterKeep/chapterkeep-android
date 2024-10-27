package com.chapter.chapterkeep.ui.screen.loginScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.chapter.chapterkeep.model.Routes
import com.chapter.chapterkeep.ui.component.ChangeButton
import com.chapter.chapterkeep.ui.component.HeaderSection
import com.chapter.chapterkeep.ui.component.InputWithCheckSection
import com.chapter.chapterkeep.ui.component.LabelledTextFieldWithLimit

@Composable
fun SignUpScreen_NickName(
    navController: NavHostController,
    viewModel: SignUpViewModel
) {
    var userNickName by viewModel::userNickName
    var userMyself by viewModel::userMyself
    val isButtonEnabled = viewModel.isNickNameInfoValid && viewModel.isNickNameAvailable


    val scrollstate = rememberScrollState()
    val context = LocalContext.current

    Scaffold(
        topBar = { HeaderSection() },
        bottomBar = {
            ChangeButton(
                label = stringResource(R.string.signup_button),
                color = { if (isButtonEnabled) R.color.main_green else R.color.gray_400 },
                fontColor = { if (isButtonEnabled) R.color.white else R.color.gray_600 }
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
                textLabel = R.string.signup_myself,
                fieldLabel = R.string.signup_myself_field,
                maxLength = 80,
                height = 130
            )
        }
    }
}
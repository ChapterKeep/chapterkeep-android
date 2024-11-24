package com.chapter.chapterkeep.ui.screen.boardScreen.baekiljangScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.chapter.chapterkeep.R
import com.chapter.chapterkeep.ui.component.ChangeButtonWithBottom
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo
import com.chapter.chapterkeep.ui.component.textfield.LabelledTextFieldWithLimit
import com.chapter.chapterkeep.ui.navigate.Routes
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.AddBoardTitleTextField
import com.chapter.chapterkeep.ui.screen.boardScreen.component.detailBoard.AddBoardTopBar

@Composable
fun AddBaekiljangScreen(
    navController: NavHostController
) {
    var isButtonEnabled by remember {
        mutableStateOf(false)
    }
    val thisMonthTitle = stringResource(R.string.addbaekiljang_this_month_title, "가을")

    var title by remember {
        mutableStateOf("")
    }
    var detail by remember {
        mutableStateOf("")
    }

    isButtonEnabled = title.isNotEmpty() && detail.isNotEmpty()

    Scaffold(
        topBar = {
            HeaderGreenLogo()
        },
        bottomBar = {
            ChangeButtonWithBottom(
                label = stringResource(R.string.addboard_button),
                color = { if (isButtonEnabled) R.color.main_green else R.color.gray_200 },
                fontColor = { if (isButtonEnabled) R.color.white else R.color.gray_700 }
            ) {
                if (isButtonEnabled) {
                    // 등록 로직
                    navController.navigate(Routes.Baekiljang.route) {
                        popUpTo(Routes.Baekiljang.route){
                            inclusive = true
                        }
                    }
                }
            }
        }
    ) { paddingValues ->

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.img_addboard_bg),
                contentDescription = null,
                modifier = Modifier
                    .size(
                        width = (LocalConfiguration.current.screenWidthDp / 2).dp,
                        height = 200.dp
                    )
                    .align(Alignment.BottomStart),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
        ) {
            AddBoardTopBar(
                stringResource(R.string.addbaekiljang_board),
                onClick = {
                    navController.navigate(Routes.Baekiljang.route) {
                        popUpTo(Routes.Baekiljang.route){
                            inclusive = true
                        }
                    }
                }
            )
            Spacer(Modifier.height(10.dp))

            Text(
                text = thisMonthTitle,
                fontSize = 13.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.main_darkgreen)
            )
            Spacer(Modifier.height(20.dp))

            AddBoardTitleTextField(
                value = title,
                onValueChange = {title = it}
            )
            Spacer(Modifier.height(15.dp))

            LabelledTextFieldWithLimit(
                value = detail,
                onValueChange = { detail = it },
                textLabel = stringResource(R.string.addboard_detail),
                fieldLabel = stringResource(R.string.addboard_detail_textfield),
                maxLength = 1500,
                height = 200
            )
        }
    }
}

@Preview
@Composable
fun AddBaekiljangPreview(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    AddBaekiljangScreen(navController)
}
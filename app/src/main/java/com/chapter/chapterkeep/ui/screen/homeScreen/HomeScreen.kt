package com.chapter.chapterkeep.ui.screen.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.ui.component.DoubleBackPressToExit
import com.chapter.chapterkeep.ui.navigate.Routes

@Composable
fun HomeScreen(navController: NavHostController) {
    DoubleBackPressToExit()
    Text(
        text = "프로필 수정 화면",
        modifier = Modifier.clickable {
            navController.navigate(Routes.EditProfile.route)
        }
    )
}
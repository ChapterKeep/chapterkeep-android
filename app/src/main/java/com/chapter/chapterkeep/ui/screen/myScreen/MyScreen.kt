package com.chapter.chapterkeep.ui.screen.myScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.chapter.chapterkeep.ui.component.Bar.BottomBar
import com.chapter.chapterkeep.ui.component.header.HeaderGreenLogo

@Composable
fun MyScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            HeaderGreenLogo()
        },
        bottomBar = {
            BottomBar(4, navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(paddingValues)
        ) {

        }
    }
}
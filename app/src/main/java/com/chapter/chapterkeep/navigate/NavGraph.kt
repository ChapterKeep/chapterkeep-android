package com.chapter.chapterkeep.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chapter.chapterkeep.screen.loginScreen.LoginScreen
import com.chapter.chapterkeep.screen.startScreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "Login"){
        // 초기 화면
        composable(route = "Splash"){
            SplashScreen(navController)
        }
        composable(route = "Login"){
            LoginScreen(navController)
        }

        //홈화면
        composable(route = "Home"){

        }
        
    }
}
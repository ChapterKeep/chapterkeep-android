package com.chapter.chapterkeep.navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.chapter.chapterkeep.screen.loginScreen.LoginScreen
import com.chapter.chapterkeep.screen.loginScreen.SignupScreen_ID
import com.chapter.chapterkeep.screen.loginScreen.SignupScreen_NickName
import com.chapter.chapterkeep.screen.startScreen.SplashScreen

@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "Signup_NickName"){
        // 초기 화면
        composable(route = "Splash"){ // 스플래시
            SplashScreen(navController)
        }
        composable(route = "Login"){ // 로그인
            LoginScreen(navController)
        }
        composable(route = "Signup_ID"){
            SignupScreen_ID(navController)
        }
        composable(route = "Signup_NickName") {
            SignupScreen_NickName(navController)
        }


        //홈화면
        composable(route = "Home"){

        }
        
    }
}